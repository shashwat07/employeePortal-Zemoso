import Route from '@ember/routing/route';
import RSVP from 'rsvp';

export default Route.extend({
  model(params){
    return RSVP.hash({
      department: this.get('store').findAll('department'),
      location: this.get('store').findAll('location'),
      project:  this.get('store').findAll('project'),
      role:  this.get('store').findAll('role'),
    });
  },
  setupController(controller, model) {
    this._super(...arguments);
    let departmentList = [];
    let locationList = [];
    let projectList = [];
    let roleList = [];

    model.department.forEach(function (department) {
      departmentList.push(department.get('name'))
    });
    controller.set('departments',departmentList);

    model.location.forEach(function (location) {
      locationList.push(location.get('name'))
    });
    controller.set('locations',locationList);

    model.project.forEach(function (project) {
      projectList.push(project.get('name'))
    });
    controller.set('projects',projectList);

    model.role.forEach(function (role) {
      roleList.push(role.get('name'))
    });
    controller.set('roles',roleList);
  }

});
