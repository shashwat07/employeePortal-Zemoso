import DS from 'ember-data';

export default DS.Model.extend({
  firstName: DS.attr(),
  middleName: DS.attr(),
  lastName: DS.attr(),
  role: DS.attr(),
  location: DS.attr(),
  startDate: DS.attr(),
  email: DS.attr(),
  phoneNumber: DS.attr(),
  bio: DS.attr(),
  skillSet: DS.attr(),
  image: DS.attr(),
  department: DS.attr(),
  project: DS.attr(),
  reportsTo: DS.attr(),

  fullName: Ember.computed('firstName', 'lastName', function() {
    return `${this.get('firstName')} ${this.get('lastName')}`;
  })

});
