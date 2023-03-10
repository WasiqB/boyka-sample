package com.github.wasiqb.web.pages;

import com.github.wasiqb.boyka.builders.Locator;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class FileUploadPage {
    private static final FileUploadPage FILE_UPLOAD_PAGE = new FileUploadPage ();

    public static FileUploadPage fileUploadPage () {
        return FILE_UPLOAD_PAGE;
    }

    private final Locator fileUpload = Locator.buildLocator ()
        .name ("File Upload input")
        .web (By.id ("file-upload"))
        .build ();
    private final Locator fileSubmit = Locator.buildLocator()
        .name ("File Submit Button")
        .web (By.id ("file-submit"))
        .build();
    private final Locator uploadedFiles = Locator.buildLocator()
        .name ("Uploaded File names")
        .web (By.id ("uploaded-files"))
        .build();
    private final Locator uploadMessage = Locator.buildLocator ()
        .name ("Upload Message")
        .web (By.tagName ("h3"))
        .build ();
}
