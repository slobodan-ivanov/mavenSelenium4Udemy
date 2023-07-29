package com.kinto.qa.util;

import com.kinto.qa.config.BaseTest;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.File;
import java.util.Optional;

public class KintoTestWatcher implements TestWatcher {
    @Override
    public void testAborted(ExtensionContext extensionContext, Throwable throwable) {
        System.out.println(">>>>>>>>>SystemWatcher - test aborted");
    }

    @Override
    public void testDisabled(ExtensionContext extensionContext, Optional<String> optional) {
        System.out.println(">>>>>>>>>SystemWatcher - test disabled");
    }

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable) {
        System.out.println(">>>>>>>>>SystemWatcher - test failed");
        try {
            String filename = "screenshot_" + BaseTest.getFormattedDate()
                    + "_" + extensionContext.getTestClass().get().getSimpleName()
                    + "_" + extensionContext.getTestMethod().get().getName() + ".png";
            FileUtils.copyFile(BaseTest.scrFile, new File(filename));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        System.out.println(">>>>>>>>>SystemWatcher - test successful");
    }
}