package CommonPO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CommonFunctionLib {

    public static String winHandleBefore;
    public static String userDir = System.getProperty("user.dir");

    /**
     * Purpose : Constructor with no argument
     */
    public CommonFunctionLib() {

    }

    public static void openNewTab(WebDriver driver, WebAction action) {

        if (driver.toString().contains("Internet")) {
            driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL + "t");// opens
        } else {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("window.open()");
        }
        action.switchToNewFrame();
    }

    public static int getNumberFromString(String string) {

        return Integer.parseInt(string.replaceAll("\\D+", ""));
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }
    }

    public static void assertTrue(boolean condition, String msg, WebDriver driver) throws Exception, IOException {
        if (!condition) {
            log("Failed log: " + msg, driver);
            throw new Exception("Functional Fail: " + msg);
        }
    }

    public static String getTodayDate() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String strDay;
        String strMonth;
        if (day < 10) {
            strDay = "0" + Integer.toString(day);
        } else {
            strDay = Integer.toString(day);
        }

        int year = calendar.get(Calendar.YEAR);

        int month = calendar.get(Calendar.MONTH);

        if (month < 10) {
            strMonth = "0" + Integer.toString(month + 1);
        } else {
            strMonth = Integer.toString(month + 1);
        }

        return strMonth + "/" + strDay + "/" + year;
    }

    public static int getNextWeekDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    public static String readFromConsole(String text) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(text);

        return br.readLine();
    }

    public static void assertEquals(String actual, String expected, String msg, WebDriver driver) throws Exception, IOException {
        if (!actual.equals(expected)) {
            log("Failed log: " + msg, driver);
            throw new Exception("Functional Fail: " + msg);
        }
    }

    /**
     * Purpose : This function injects file path into Windows File Upload dialog
     */
    private static Robot robot;

    public static void UploadFile(String filePath) throws AWTException {
        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        robot = new Robot();
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(500);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_V);
        robot.delay(500);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(500);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(500);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void keyPress(int keycode, int count) {
        for (int i = 0; i < count; i++) {
            try {
                robot = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
            robot.keyPress(keycode);
            sleep(1);
            robot.keyRelease(keycode);
        }
    }

    public static void copyToClipboard(String text) {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
    }

    public static String getCurrentDateAndTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    /***
     *
     * @param location
     */
    public void CreateFolder(String location) {
        File Log = new File(location);
        if (Log.exists()) {
        } else new File(location).mkdir();
    }

    public static String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String strDay = "";
        if (day < 10) strDay = "0" + Integer.toString(day);

        int year = calendar.get(Calendar.YEAR);

        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();

        int month = calendar.get(Calendar.MONTH);

        int i = 3;
        String strMonth = months[month].substring(0, i) + months[month].substring(i + 2);

        return strDay + strMonth + year;
    }

    public static void tryAgain(Method method, int tryCount) throws Exception {
        int count = 0;
        while (true) {
            try {
                method.method();
                break;
            } catch (Exception e) {
                CommonFunctionLib.sleep(1);
                count++;
                if (count == tryCount) {
                    count = 0;
                    throw new Exception(e.getLocalizedMessage());
                }
            }
        }
    }

    public static void tryAgainBool(Method method, int seconds, Boolean val) throws Exception {
        int count = 0;
        while (true) {
            try {
                method.method();
                break;
            } catch (Exception e) {
                CommonFunctionLib.sleep(1);
                count++;
                if (count == seconds) {
                    count = 0;
                    if (val) {
                        throw new Exception(e.getLocalizedMessage());
                    }
                }
            }
        }
    }

    public static void tryAgain(Method method, int seconds, int i) throws Exception {
        int count = 0;
        while (true) {
            try {
                method.method();
                break;
            } catch (Exception e) {
                CommonFunctionLib.sleep(1);
                count++;
                if (count == seconds) {
                    count = 0;
                    throw new Exception(e.getLocalizedMessage());
                }
            }
        }
    }

    /**
     * @param method
     * @param delayPeriod
     */
    public static void timer(Method method, int tiggerTime, int delayPeriod, boolean tiggerTimer) {
        if (tiggerTimer) {
            Timer t = new Timer();
            t.schedule(new TimerTask() {
                int count = 0;

                @Override
                public void run() {
                    System.out.println("timer: " + count);
                    if (tiggerTime == count) {
                        try {
                            method.method();
                        } catch (Exception e) {
                        }
                        t.cancel();
                    } else {
                        count++;
                    }
                }
            }, 0, (delayPeriod * 1000));
        }
    }

    public static void backgroundChkUntilTrue1(WaitMethods method, Method m, int tiggerTime, int timeOut) {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            int count = 0;

            @Override
            public void run() {
                System.out.println("timer: " + count);
                if (tiggerTime == count) {
                    try {
                        if (method.trueCondition()) {
                            m.method();
                            t.cancel();
                        } else if (count == timeOut) {
                            t.cancel();
                        }
                    } catch (Exception e) {
                    }
                } else {
                    count++;
                }
            }
        }, 0, (1000));

    }

    // method for add log to report
    public static void log(String log, WebDriver driver) throws Exception, IOException {
        if (driver != null) {
            tryAgain(() -> {
                System.out.println(driver + ": " + log);
                /*
                 * Reporter.log("<a href=\"" + new
				 * CaptureBrowserScreenShot().takeScreenShots(driver) + "\"> " +
				 * log + "</a> <br />");
				 */
            }, 3);
        }
    }


    public static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }

    public static void deleteFiles(Path path) {
        try {
            Files.walk(path, FileVisitOption.FOLLOW_LINKS).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
        } catch (IOException e) {
        }
    }

    public static int randInt(int min, int max) {
        // Usually this can be a field rather than a method variable
        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static void confirmSecurityException(WebAction action, WebDriver driver) throws Exception {
        CommonFunctionLib.sleep(1);
        try {
            action.click(driver.findElement(By.id("advancedButton")));
            CommonFunctionLib.log("Click on 'Advance' button", driver);

            action.click(driver.findElement(By.id("exceptionDialogButton")));
            CommonFunctionLib.log("Click on 'Add Exception' button", driver);

            CommonFunctionLib.keyPress(KeyEvent.VK_TAB, 4);
            CommonFunctionLib.keyPress(KeyEvent.VK_ENTER, 1);
            CommonFunctionLib.log("Confirm Secutity Exception", driver);
        } catch (Exception e) {
        }
    }

    public static void setImplicitlyWait(int seconds, WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static void waitUntilTrue(WaitMethods wait, int seconds, WebDriver driver) {
        int count = 0;
        setImplicitlyWait(1, driver);

        while (true) {
            if (wait.trueCondition()) {
                break;
            } else {
                CommonFunctionLib.sleep(1);
                count++;
                if (count == seconds) {
                    break;
                }
            }
        }
        setImplicitlyWait(15, driver);
    }


    public static boolean waitUntilFalse(WaitMethods wait, int seconds, WebDriver driver) {
        setImplicitlyWait(1, driver);
        int count = 0;
        while (true) {
            System.err.println("val: " + wait.trueCondition());
            if (!wait.trueCondition()) {
                setImplicitlyWait(15, driver);
                return true;
            } else {
                CommonFunctionLib.sleep(1);
                count++;
                if (count == seconds) {
                    setImplicitlyWait(15, driver);
                    return false;
                }
            }
        }

    }
}