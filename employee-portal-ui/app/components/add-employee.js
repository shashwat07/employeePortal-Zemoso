import Component from '@ember/component';
import {inject as service} from '@ember/service';
import { A } from '@ember/array';
import { map, filter } from '@ember/object/computed';
import { computed } from '@ember/object';

export default Component.extend({
  init() {
    this.initialize();
    this._super();
  },

  initialize() {
    var url = window.location.href;
    var id = url.substring(url.lastIndexOf('/') + 1);
    this.getEmployee(id).then((data) => {
      this.set('employee', data);
    });
  },

  getEmployee(id) {
    const store = this.get('store');
    return store.findRecord('employee',id);
  },

  router: Ember.inject.service(),
  employee:{},
  store: service(),
  updatedEmployee:{},
  imageUrl : '',
  skillSet : '',
  routerTo: service('-routing'),

names : computed(function () {
    const self = this;
    var empNames = this.get('store').findAll('employee').then(function(employee){
      var nameList = [];
      employee.forEach(function (employee) {
        if(employee.get('firstName')!= undefined){
          nameList.push(employee.get('fullName'));
        }
      });
      return nameList;
    });
    return empNames;
  }),

  skills: computed('employee.skillSet', function () {
    if(typeof this.get('employee.skillSet') === "undefined"){
      return A([]);
    }
    else{
      return A(this.get('employee.skillSet').split(','));
    }
  }),

  allSkills: A(['Ember','Java','HTML','CSS','JavaScript','Python', 'Ruby', 'Pearl', 'Angular']),

  remainingSkills: computed('skills.length', function() {
    return this.get('allSkills').filter((source) => {
      return !this.get('skills').any(function(mySkill) {
        return source === mySkill;
      });
    });
  }),

  actions: {
    addEmployee(){
      this.set('skillSet',this.get('skills').toString());
      let employeeData = this.get('employee');
      employeeData['image'] = this.get('imageUrl');
      employeeData['skillSet'] = this.get('skillSet');
      let data;
      const self = this;
      if(typeof employeeData['id'] === "undefined"){
        data = this.get('store').createRecord('employee',{
          firstName : employeeData['firstName'],
          middleName : employeeData['middleName'],
          lastName : employeeData['lastName'],
          role : employeeData['role'],
          location : employeeData['location'],
          startDate : employeeData['startDate'],
          email : employeeData['email'],
          phoneNumber : employeeData['phoneNumber'],
          bio : employeeData['bio'],
          skillSet : employeeData['skillSet'],
          department : employeeData['department'],
          project : employeeData['project'],
          image: employeeData['image'],
          reportsTo: employeeData['reportsTo']
        });

        data.save().then(
          self.get('routerTo').transitionTo('employees')
        );
      }
      else{
        this.get('store').findRecord('employee', employeeData['id']).then(function(employee) {
          employeeData.save().then(
            self.get('routerTo').transitionTo('employees')
          );
        });
      }
    },

    removeSkill(item) {
      this.get('skills').removeObject(item);
    },

    addSkill(item) {
      this.get('skills').pushObject(item);
    },

    upload: function(event) {
      const file = event.target.files[0];

      if(file){
        let read = new FileReader();
        read.onload = function(e){
          $('#img-preview').attr('src', e.target.result);
        };

        read.readAsDataURL(file);
      }

      getBase64(file).then(
        data => this.set('imageUrl',data),
      );

       function getBase64(file) {
        return new Promise((resolve, reject) => {
          const reader = new FileReader();
          reader.readAsDataURL(file);
          reader.onload = () => resolve(reader.result);
          reader.onerror = error => reject(error);
        });
      }
    }
  }
});
