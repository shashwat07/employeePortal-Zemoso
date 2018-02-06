import Component from '@ember/component';
import {inject as service} from '@ember/service';
import { A } from '@ember/array';
import { map, filter } from '@ember/object/computed';
import { computed } from '@ember/object';

export default Component.extend({
  setBySearchable: null,
  employee:{},
  store: service(),
  updatedEmployee:{},

  roles:['Software Developer','Senior Software Developer','Project Manager','Business Analyst'],
  locations:['Bangalore', 'Hyderabad', 'Pune', 'Noida', 'New York', 'California', 'Moscow'],
  departments:['HR','Business','Legal','Tech'],
  projects:['Drone', 'Zededup', 'Push-Notification'],
  manager:'',
  names: ['Stefan', 'Miguel', 'Tomster', 'Pluto'],

  skills: A([]),

  allSkills: A(['Ember','Java','HTML','CSS','JavaScript','Python']),

  remainingSkills: computed('skills.length', function() {
    return this.get('allSkills').filter((source) => {
      return !this.get('skills').any(function(mySkill) {
        return source === mySkill;
      });
    });
  }),

  actions: {
    addEmployee(){
      let employeeData = this.get('employee');
      let data;
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
          //skills : this.get('skills'),
          department : employeeData['department'],
          project : employeeData['project'],
          image: employeeData['image'],
          reportsTo: employeeData['reportsTo']
        });
        data.save();
      }
      else{
        this.get('store').findRecord('employee', employeeData['id']).then(function(employee) {
          let updatedEmployee ={};
          updatedEmployee['id'] = employeeData.get('id');
          updatedEmployee['firstName'] = employeeData.get('firstName');
          updatedEmployee['middleName'] = employeeData.get('middleName');
          updatedEmployee['lastName'] = employeeData.get('lastName');
          updatedEmployee['role'] = employeeData.get('role');
          updatedEmployee['location'] = employeeData.get('location');
          updatedEmployee['startDate'] = employeeData.get('startDate');
          updatedEmployee['email'] = employeeData.get('email');
          updatedEmployee['phoneNumber'] = employeeData.get('phoneNumber');
          updatedEmployee['bio'] = employeeData.get('bio');
          //updatedEmployee['skills'] = this.get('skills');
          updatedEmployee['department'] = employeeData.get('department');
          updatedEmployee['project'] = employeeData.get('project');
          updatedEmployee['image'] = employeeData.get('image');
          updatedEmployee['reportsTo'] = employeeData.get('reportsTo'),

          employee.save();
        });
      }
      this.transitionTo('employees');
    },

    removeSkill(item) {
      this.get('skills').removeObject(item);
    },

    addSkill(item) {
      this.get('skills').pushObject(item);
    },

    upload: function(event) {
      const reader = new FileReader();
      const file = event.target.files[0];
      if (file) {
        reader.readAsDataURL(file);
      }
    }
  }

});
