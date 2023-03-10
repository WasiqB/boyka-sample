package com.github.wasiqb.web;

import static com.github.wasiqb.boyka.actions.drivers.NavigateActions.navigate;
import static com.github.wasiqb.boyka.actions.elements.ClickableActions.withMouse;
import static com.github.wasiqb.boyka.actions.elements.ElementActions.onElement;
import static com.github.wasiqb.boyka.actions.elements.TextBoxActions.onTextBox;
import static com.github.wasiqb.boyka.manager.DriverManager.closeDriver;
import static com.github.wasiqb.boyka.manager.DriverManager.createDriver;
import static com.github.wasiqb.web.actions.InputFormActions.fillForm;
import static com.github.wasiqb.web.actions.InputFormActions.verifySuccessMessage;
import static com.github.wasiqb.web.pages.FileUploadPage.fileUploadPage;
import static java.lang.System.getProperty;
import static java.text.MessageFormat.format;

import java.text.MessageFormat;

import com.github.wasiqb.boyka.enums.PlatformType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTest {
    @BeforeTest
    public void setupTest () {
        createDriver (PlatformType.WEB, "test_chrome");
    }

    @AfterTest
    public void teardownTest () {
        closeDriver ();
    }

    @Test
    public void testWeb () {
        fillForm ();
        verifySuccessMessage ();
    }

    @Test
    public void testFileUpload () {
        navigate ().to ("http://the-internet.herokuapp.com/upload");

        var fileName = format ("{0}/src/test/resources/test-file.txt", getProperty ("user.dir"));
        onTextBox (fileUploadPage ().getFileUpload ()).enterText (fileName);
        withMouse (fileUploadPage ().getFileSubmit ()).submit ();

        onElement (fileUploadPage ().getUploadMessage ()).verifyText ().isEqualTo ("File Uploaded!");
        onElement (fileUploadPage ().getUploadedFiles ()).verifyText ().contains ("test-file.txt");
    }
}
