import Component from '@ember/component';
import {inject as service} from '@ember/service';
import { A } from '@ember/array';
import { map, filter } from '@ember/object/computed';
import { computed } from '@ember/object';

export default Component.extend({
  store: service(),
  init() {
    this.initialize();
    this._super();
  },

  initialize() {
    var url = window.location.href;
    var id = url.substring(url.lastIndexOf('/') + 1);
    this.getEmployee(id).then((data) => {
      this.set('employee', data);
      this.set('skillSet',A(this.get('employee.skillSet').split(',')));
    });
  },

  getEmployee(id) {
    const store = this.get('store');
    return store.findRecord('employee',id);
  }
});
