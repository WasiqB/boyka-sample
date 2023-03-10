package com.github.wasiqb.web.actions;

import static com.github.wasiqb.boyka.actions.drivers.NavigateActions.navigate;
import static com.github.wasiqb.boyka.actions.drivers.WindowActions.onWindow;
import static com.github.wasiqb.boyka.actions.elements.ClickableActions.withMouse;
import static com.github.wasiqb.boyka.actions.elements.DropDownActions.onDropDown;
import static com.github.wasiqb.boyka.actions.elements.ElementActions.onElement;
import static com.github.wasiqb.boyka.actions.elements.TextBoxActions.onTextBox;
import static com.github.wasiqb.web.pages.InputFormPage.inputFormPage;

import net.datafaker.Faker;

public class InputFormActions {

    public static void fillForm () {
        var faker = new Faker ();

        navigate ().to ("https://www.lambdatest.com/selenium-playground/input-form-demo");

        onTextBox (inputFormPage ().getName ()).enterText (faker.name ().fullName ());
        onTextBox (inputFormPage ().getEmailId ()).enterText (faker.internet ().emailAddress ());
        onTextBox (inputFormPage ().getPassword ()).enterText (faker.funnyName ().name ());
        onTextBox (inputFormPage ().getCompany ()).enterText (faker.name ().username ());
        onTextBox (inputFormPage ().getWebsite ()).enterText (faker.internet ().domainName ());
        onDropDown (inputFormPage ().getCountry ()).selectByText ("India");
        onTextBox (inputFormPage ().getCity ()).enterText ("Mumbai");
        onTextBox (inputFormPage ().getAddress1 ()).enterText (faker.address ().streetAddress ());
        onTextBox (inputFormPage ().getAddress2 ()).enterText (faker.address ().secondaryAddress ());
        onTextBox (inputFormPage ().getState ()).enterText ("Maharashtra");
        onTextBox (inputFormPage ().getZipCode ()).enterText ("400001");

        onWindow ().takeScreenshot ();

        withMouse (inputFormPage ().getSubmit ()).click ();
    }

    public static void verifySuccessMessage () {
        onElement (inputFormPage ().getSuccessMessage ())
            .verifyText ().isEqualTo ("Thanks for contacting us, we will get back to you shortly.");
    }
}
