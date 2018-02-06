import EmberRouter from '@ember/routing/router';
import config from './config/environment';

const Router = EmberRouter.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('employees');
  this.route('new-employee');
  this.route('edit-employee',{path: 'edit-employee/:id'});
  this.route('employee',{path: 'view-employee/:id'});
});

export default Router;
