import DS from 'ember-data';

export default DS.Model.extend({
  firstName: DS.attr(),
  middleName: DS.attr(),
  lastName: DS.attr(),
  role: DS.attr(),
  phoneNumber: DS.attr(),
  imageUrl: DS.attr()
});
