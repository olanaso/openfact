/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openfact.testsuite.model;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class InvoiceModelTest extends AbstractModelTest {

    /*@Test
    public void persistUser() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        OpenfactSession session = organizationManager.getSession();
        UserModel user = session.users().addUser(organization, "user");
        user.setFirstName("first-name");
        user.setLastName("last-name");
        user.setEmail("email");
        assertNotNull(user.getCreatedTimestamp());
        // test that timestamp is current with 10s tollerance
        Assert.assertTrue((System.currentTimeMillis() - user.getCreatedTimestamp()) < 10000);

        user.addRequiredAction(RequiredAction.CONFIGURE_TOTP);
        user.addRequiredAction(RequiredAction.UPDATE_PASSWORD);

        OrganizationModel searchOrganization = organizationManager.getOrganization(organization.getId());
        UserModel persisted = session.users().getUserByUsername("user", searchOrganization);

        assertEquals(user, persisted);

        searchOrganization = organizationManager.getOrganization(organization.getId());
        UserModel persisted2 =  session.users().getUserById(user.getId(), searchOrganization);
        assertEquals(user, persisted2);

        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put(UserModel.LAST_NAME, "last-name");
        List<UserModel> search = session.users().searchForUser(attributes, organization);
        Assert.assertEquals(search.size(), 1);
        Assert.assertEquals(search.get(0).getUsername(), "user");

        attributes.clear();
        attributes.put(UserModel.EMAIL, "email");
        search = session.users().searchForUser(attributes, organization);
        Assert.assertEquals(search.size(), 1);
        Assert.assertEquals(search.get(0).getUsername(), "user");

        attributes.clear();
        attributes.put(UserModel.LAST_NAME, "last-name");
        attributes.put(UserModel.EMAIL, "email");
        search = session.users().searchForUser(attributes, organization);
        Assert.assertEquals(search.size(), 1);
        Assert.assertEquals(search.get(0).getUsername(), "user");
    }
    
    @Test
    public void webOriginSetTest() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        ClientModel client = organization.addClient("user");

        Assert.assertTrue(client.getWebOrigins().isEmpty());

        client.addWebOrigin("origin-1");
        Assert.assertEquals(1, client.getWebOrigins().size());

        client.addWebOrigin("origin-2");
        Assert.assertEquals(2, client.getWebOrigins().size());

        client.removeWebOrigin("origin-2");
        Assert.assertEquals(1, client.getWebOrigins().size());

        client.removeWebOrigin("origin-1");
        Assert.assertTrue(client.getWebOrigins().isEmpty());

        client = organization.addClient("oauthclient2");

        Assert.assertTrue(client.getWebOrigins().isEmpty());

        client.addWebOrigin("origin-1");
        Assert.assertEquals(1, client.getWebOrigins().size());

        client.addWebOrigin("origin-2");
        Assert.assertEquals(2, client.getWebOrigins().size());

        client.removeWebOrigin("origin-2");
        Assert.assertEquals(1, client.getWebOrigins().size());

        client.removeWebOrigin("origin-1");
        Assert.assertTrue(client.getWebOrigins().isEmpty());

    }

    @Test
    public void testUserRequiredActions() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        UserModel user = session.users().addUser(organization, "user");

        Assert.assertTrue(user.getRequiredActions().isEmpty());

        user.addRequiredAction(RequiredAction.CONFIGURE_TOTP);
        String id = organization.getId();
        commit();
        organization = organizationManager.getOrganization(id);
        user = session.users().getUserByUsername("user", organization);

        Assert.assertEquals(1, user.getRequiredActions().size());
        Assert.assertTrue(user.getRequiredActions().contains(RequiredAction.CONFIGURE_TOTP.name()));

        user.addRequiredAction(RequiredAction.CONFIGURE_TOTP);
        user = session.users().getUserByUsername("user", organization);

        Assert.assertEquals(1, user.getRequiredActions().size());
        Assert.assertTrue(user.getRequiredActions().contains(RequiredAction.CONFIGURE_TOTP.name()));

        user.addRequiredAction(RequiredAction.VERIFY_EMAIL.name());
        user = session.users().getUserByUsername("user", organization);

        Assert.assertEquals(2, user.getRequiredActions().size());
        Assert.assertTrue(user.getRequiredActions().contains(RequiredAction.CONFIGURE_TOTP.name()));
        Assert.assertTrue(user.getRequiredActions().contains(RequiredAction.VERIFY_EMAIL.name()));

        user.removeRequiredAction(RequiredAction.CONFIGURE_TOTP.name());
        user = session.users().getUserByUsername("user", organization);

        Assert.assertEquals(1, user.getRequiredActions().size());
        Assert.assertTrue(user.getRequiredActions().contains(RequiredAction.VERIFY_EMAIL.name()));

        user.removeRequiredAction(RequiredAction.VERIFY_EMAIL.name());
        user = session.users().getUserByUsername("user", organization);

        Assert.assertTrue(user.getRequiredActions().isEmpty());
    }

    @Test
    public void testUserMultipleAttributes() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        UserModel user = session.users().addUser(organization, "user");
        UserModel userNoAttrs = session.users().addUser(organization, "user-noattrs");

        user.setSingleAttribute("key1", "value1");
        List<String> attrVals = new ArrayList<>(Arrays.asList( "val21", "val22" ));
        user.setAttribute("key2", attrVals);

        commit();

        // Test read attributes
        organization = organizationManager.getOrganizationByName("original");
        user = session.users().getUserByUsername("user", organization);

        attrVals = user.getAttribute("key1");
        Assert.assertEquals(1, attrVals.size());
        Assert.assertEquals("value1", attrVals.get(0));
        Assert.assertEquals("value1", user.getFirstAttribute("key1"));

        attrVals = user.getAttribute("key2");
        Assert.assertEquals(2, attrVals.size());
        Assert.assertTrue(attrVals.contains("val21"));
        Assert.assertTrue(attrVals.contains("val22"));

        attrVals = user.getAttribute("key3");
        Assert.assertTrue(attrVals.isEmpty());
        Assert.assertNull(user.getFirstAttribute("key3"));

        Map<String, List<String>> allAttrVals = user.getAttributes();
        Assert.assertEquals(2, allAttrVals.size());
        Assert.assertEquals(allAttrVals.get("key1"), user.getAttribute("key1"));
        Assert.assertEquals(allAttrVals.get("key2"), user.getAttribute("key2"));

        // Test remove and rewrite attribute
        user.removeAttribute("key1");
        user.setSingleAttribute("key2", "val23");

        commit();

        organization = organizationManager.getOrganizationByName("original");
        user = session.users().getUserByUsername("user", organization);
        Assert.assertNull(user.getFirstAttribute("key1"));
        attrVals = user.getAttribute("key2");
        Assert.assertEquals(1, attrVals.size());
        Assert.assertEquals("val23", attrVals.get(0));
    }

    // OPENFACT-3494
    @Test
    public void testUpdateUserAttribute() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        UserModel user = session.users().addUser(organization, "user");

        user.setSingleAttribute("key1", "value1");

        commit();

        organization = organizationManager.getOrganizationByName("original");
        user = session.users().getUserByUsername("user", organization);

        // Update attribute
        List<String> attrVals = new ArrayList<>(Arrays.asList( "val2" ));
        user.setAttribute("key1", attrVals);
        Map<String, List<String>> allAttrVals = user.getAttributes();

        // Ensure same transaction is able to see updated value
        Assert.assertEquals(1, allAttrVals.size());
        Assert.assertEquals(allAttrVals.get("key1"), Arrays.asList("val2"));

        commit();
    }

    @Test
    public void testSearchByString() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        UserModel user1 = session.users().addUser(organization, "user1");

        commit();
        organization = session.organizations().getOrganizationByName("original");
        List<UserModel> users = session.users().searchForUser("user", organization, 0, 7);
        Assert.assertTrue(users.contains(user1));
    }

    @Test
    public void testSearchByUserAttribute() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        UserModel user1 = session.users().addUser(organization, "user1");
        UserModel user2 = session.users().addUser(organization, "user2");
        UserModel user3 = session.users().addUser(organization, "user3");

        user1.setSingleAttribute("key1", "value1");
        user1.setSingleAttribute("key2", "value21");

        user2.setSingleAttribute("key1", "value1");
        user2.setSingleAttribute("key2", "value22");

        user3.setSingleAttribute("key2", "value21");

        commit();
        organization = session.organizations().getOrganizationByName("original");

        List<UserModel> users = session.users().searchForUserByUserAttribute("key1", "value1", organization);
        Assert.assertEquals(2, users.size());
        Assert.assertTrue(users.contains(user1));
        Assert.assertTrue(users.contains(user2));

        users = session.users().searchForUserByUserAttribute("key2", "value21", organization);
        Assert.assertEquals(2, users.size());
        Assert.assertTrue(users.contains(user1));
        Assert.assertTrue(users.contains(user3));

        users = session.users().searchForUserByUserAttribute("key2", "value22", organization);
        Assert.assertEquals(1, users.size());
        Assert.assertTrue(users.contains(user2));

        users = session.users().searchForUserByUserAttribute("key3", "value3", organization);
        Assert.assertEquals(0, users.size());
    }

    @Test
    public void testServiceAccountLink() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        ClientModel client = organization.addClient("foo");

        UserModel user1 = session.users().addUser(organization, "user1");
        user1.setFirstName("John");
        user1.setLastName("Doe");

        UserModel user2 = session.users().addUser(organization, "user2");
        user2.setFirstName("John");
        user2.setLastName("Doe");

        // Search
        Assert.assertNull(session.users().getServiceAccount(client));
        List<UserModel> users = session.users().searchForUser("John Doe", organization);
        Assert.assertEquals(2, users.size());
        Assert.assertTrue(users.contains(user1));
        Assert.assertTrue(users.contains(user2));

        // Link service account
        user1.setServiceAccountClientLink(client.getId());

        commit();

        // Search and assert service account user not found
        organization = organizationManager.getOrganizationByName("original");
        client = organization.getClientByClientId("foo");
        UserModel searched = session.users().getServiceAccount(client);
        Assert.assertEquals(searched, user1);
        users = session.users().searchForUser("John Doe", organization);
        Assert.assertEquals(1, users.size());
        Assert.assertFalse(users.contains(user1));
        Assert.assertTrue(users.contains(user2));

        users = session.users().getUsers(organization, false);
        Assert.assertEquals(1, users.size());
        Assert.assertFalse(users.contains(user1));
        Assert.assertTrue(users.contains(user2));

        users = session.users().getUsers(organization, true);
        Assert.assertEquals(2, users.size());
        Assert.assertTrue(users.contains(user1));
        Assert.assertTrue(users.contains(user2));

        Assert.assertEquals(2, session.users().getUsersCount(organization));

        // Remove client
        new ClientManager(organizationManager).removeClient(organization, client);
        commit();

        // Assert service account removed as well
        organization = organizationManager.getOrganizationByName("original");
        Assert.assertNull(session.users().getUserByUsername("user1", organization));
    }

    @Test
    public void testGrantToAll() {
        OrganizationModel organization1 = organizationManager.createOrganization("organization1");
        RoleModel role1 = organization1.addRole("role1");
        UserModel user1 = organizationManager.getSession().users().addUser(organization1, "user1");
        UserModel user2 = organizationManager.getSession().users().addUser(organization1, "user2");

        OrganizationModel organization2 = organizationManager.createOrganization("organization2");
        UserModel organization2User1 = organizationManager.getSession().users().addUser(organization2, "user1");

        commit();

        organization1 = organizationManager.getOrganizationByName("organization1");
        role1 = organization1.getRole("role1");
        organizationManager.getSession().users().grantToAllUsers(organization1, role1);

        commit();

        organization1 = organizationManager.getOrganizationByName("organization1");
        role1 = organization1.getRole("role1");
        user1 = organizationManager.getSession().users().getUserByUsername("user1", organization1);
        user2 = organizationManager.getSession().users().getUserByUsername("user2", organization1);
        Assert.assertTrue(user1.hasRole(role1));
        Assert.assertTrue(user2.hasRole(role1));

        organization2 = organizationManager.getOrganizationByName("organization2");
        organization2User1 = organizationManager.getSession().users().getUserByUsername("user1", organization2);
        Assert.assertFalse(organization2User1.hasRole(role1));
    }

    public static void assertEquals(UserModel expected, UserModel actual) {
        Assert.assertEquals(expected.getUsername(), actual.getUsername());
        Assert.assertEquals(expected.getCreatedTimestamp(), actual.getCreatedTimestamp());
        Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
        Assert.assertEquals(expected.getLastName(), actual.getLastName());

        String[] expectedRequiredActions = expected.getRequiredActions().toArray(new String[expected.getRequiredActions().size()]);
        Arrays.sort(expectedRequiredActions);
        String[] actualRequiredActions = actual.getRequiredActions().toArray(new String[actual.getRequiredActions().size()]);
        Arrays.sort(actualRequiredActions);

        Assert.assertArrayEquals(expectedRequiredActions, actualRequiredActions);
    }*/

}

