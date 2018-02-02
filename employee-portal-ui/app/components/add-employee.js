import Component from '@ember/component';
import {inject as service} from '@ember/service';

export default Component.extend({

/*  model(){
    let emp = this.get('store').findAll('employee');
    return emp;
  },*/

 /* onSelectionChange(e){

  },*/

  setBySearchable: null,
  employee:{},
  store: service(),

  roles:['Software Developer','Senior Software Developer','Project Manager','Business Analyst'],
  locations:['Bangalore', 'Hyderabad', 'Pune', 'Noida', 'New York', 'California', 'Moscow'],
  managers:[],
  skills:[],
  remainingSkills:['Ember','Java','HTML','CSS','JavaScript','Python'],
  departments:['HR','Business','Legal','Tech'],
  projects:['drone', 'Zededup', 'Push-Notification'],

  actions: {
    addEmployee(){
      let obj = this.get('employee');
      let data = this.get('store').createRecord('newEmployee',{
        firstName : obj['firstName'],
        middleName : obj['middleName'],
        lastName : obj['lastName'],
        role : obj['role'],
        location : obj['location'],
        startDate : obj['startDate'],
        email : obj['email'],
        phoneNumber : obj['phoneNumber'],
        bio : obj['bio'],
        skills : this.get('skills'),
        department : obj['department'],
        project : obj['project'],
        imageUrl: obj['imageUrl']
      });
      data.save();
    },

    removeSkill(empSkill){
      var index = this.get('skills').indexOf(empSkill);
      if (index > -1) {
        this.get('skills').splice(index, 1);
        this.get('remainingSkills').pushObject(empSkill);
      }
    },

    addSkill:function(empSkill){
      var index = this.get('remainingSkills').indexOf(empSkill);
      if (index > -1) {
        this.get('remainingSkills').splice(index, 1);
        this.get('skills').pushObject(empSkill);
      }
    }
  }

});
