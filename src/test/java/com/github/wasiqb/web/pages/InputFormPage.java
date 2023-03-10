package com.github.wasiqb.web.pages;

import com.github.wasiqb.boyka.builders.Locator;
import lombok.Data;
import org.openqa.selenium.By;

@Data
public class InputFormPage {
    private static final InputFormPage INPUT_FORM_PAGE = new InputFormPage ();

    public static InputFormPage inputFormPage () {
        return INPUT_FORM_PAGE;
    }

    private final Locator formContainer  = Locator.buildLocator ()
        .name ("Form Container")
        .web (By.id ("seleniumform"))
        .build ();
    private final Locator name           = Locator.buildLocator ()
        .name ("Name")
        .web (By.id ("name"))
        .parent (formContainer)
        .build ();
    private final Locator emailId        = Locator.buildLocator ()
        .name ("Email ID")
        .web (By.id ("inputEmail4"))
        .parent (formContainer)
        .build ();
    private final Locator password       = Locator.buildLocator ()
        .name ("Password")
        .web (By.id ("inputPassword4"))
        .parent (formContainer)
        .build ();
    private final Locator company        = Locator.buildLocator ()
        .name ("Company")
        .web (By.id ("company"))
        .parent (formContainer)
        .build ();
    private final Locator website        = Locator.buildLocator ()
        .name ("Website")
        .web (By.id ("websitename"))
        .parent (formContainer)
        .build ();
    private final Locator country        = Locator.buildLocator ()
        .name ("Country")
        .web (By.name ("country"))
        .parent (formContainer)
        .build ();
    private final Locator city           = Locator.buildLocator ()
        .name ("City")
        .web (By.id ("inputCity"))
        .parent (formContainer)
        .build ();
    private final Locator address1       = Locator.buildLocator ()
        .name ("Address 1")
        .web (By.id ("inputAddress1"))
        .parent (formContainer)
        .build ();
    private final Locator address2       = Locator.buildLocator ()
        .name ("Address 2")
        .web (By.id ("inputAddress2"))
        .parent (formContainer)
        .build ();
    private final Locator state          = Locator.buildLocator ()
        .name ("State")
        .web (By.id ("inputState"))
        .parent (formContainer)
        .build ();
    private final Locator zipCode        = Locator.buildLocator ()
        .name ("Zip Code")
        .web (By.id ("inputZip"))
        .parent (formContainer)
        .build ();
    private final Locator submit         = Locator.buildLocator ()
        .name ("Submit")
        .web (By.tagName ("button"))
        .parent (formContainer)
        .build ();
    private final Locator successMessage = Locator.buildLocator ()
        .name ("Success message")
        .web (By.className ("success-msg"))
        .build ();
}
