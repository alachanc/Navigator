package org.lachance.assistant;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;

class ExecutiveFunction {
    protected Deque<AssistantState> contexts;
    protected Assistant ass = new Assistant();

    ExecutiveFunction(){
        contexts = new LinkedList<>();
    }

    public void interpret(String str){
        //Do stuff
        execute(str); //Will change
    }

    public void execute(String str){
        getState().doAction(ass, str);
    }

    public void setState(AssistantState state){
        contexts.addLast(state);
    }

    public AssistantState getState(){
        return contexts.peekLast();
    }
}

public class Assistant {

    protected Robot robot;
    protected Clipboard clipboard;

    Assistant(){
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    protected void doType(int keyCode) {
        try {
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        } catch (Exception e) {
            System.out.println("Invalid key code(s) for above character");
        }
    }

    protected void doType(int keyCode1, int keyCode2) {
        try {
            robot.keyPress(keyCode1);
            robot.keyPress(keyCode2);
            robot.keyRelease(keyCode2);
            robot.keyRelease(keyCode1);
        } catch (Exception e) {
            System.out.println("Invalid key code(s) for above character");
        }
    }

    protected void type(@NotNull String content) {
        int length = content.length();
        for (int i = 0; i < length; i++) {
            type(content.charAt(i));
        }
    }

    protected void type(char character) {
        switch (character) {
            case 'a' -> doType(KeyEvent.VK_A);
            case 'b' -> doType(KeyEvent.VK_B);
            case 'c' -> doType(KeyEvent.VK_C);
            case 'd' -> doType(KeyEvent.VK_D);
            case 'e' -> doType(KeyEvent.VK_E);
            case 'f' -> doType(KeyEvent.VK_F);
            case 'g' -> doType(KeyEvent.VK_G);
            case 'h' -> doType(KeyEvent.VK_H);
            case 'i' -> doType(KeyEvent.VK_I);
            case 'j' -> doType(KeyEvent.VK_J);
            case 'k' -> doType(KeyEvent.VK_K);
            case 'l' -> doType(KeyEvent.VK_L);
            case 'm' -> doType(KeyEvent.VK_M);
            case 'n' -> doType(KeyEvent.VK_N);
            case 'o' -> doType(KeyEvent.VK_O);
            case 'p' -> doType(KeyEvent.VK_P);
            case 'q' -> doType(KeyEvent.VK_Q);
            case 'r' -> doType(KeyEvent.VK_R);
            case 's' -> doType(KeyEvent.VK_S);
            case 't' -> doType(KeyEvent.VK_T);
            case 'u' -> doType(KeyEvent.VK_U);
            case 'v' -> doType(KeyEvent.VK_V);
            case 'w' -> doType(KeyEvent.VK_W);
            case 'x' -> doType(KeyEvent.VK_X);
            case 'y' -> doType(KeyEvent.VK_Y);
            case 'z' -> doType(KeyEvent.VK_Z);
            case 'A' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_A);
            case 'B' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
            case 'C' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_C);
            case 'D' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_D);
            case 'E' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_E);
            case 'F' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_F);
            case 'G' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_G);
            case 'H' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_H);
            case 'I' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_I);
            case 'J' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_J);
            case 'K' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_K);
            case 'L' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_L);
            case 'M' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_M);
            case 'N' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_N);
            case 'O' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_O);
            case 'P' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_P);
            case 'Q' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Q);
            case 'R' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_R);
            case 'S' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_S);
            case 'T' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_T);
            case 'U' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_U);
            case 'V' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_V);
            case 'W' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_W);
            case 'X' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_X);
            case 'Y' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Y);
            case 'Z' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Z);
            case '`' -> doType(KeyEvent.VK_BACK_QUOTE);
            case '0' -> doType(KeyEvent.VK_0);
            case '1' -> doType(KeyEvent.VK_1);
            case '2' -> doType(KeyEvent.VK_2);
            case '3' -> doType(KeyEvent.VK_3);
            case '4' -> doType(KeyEvent.VK_4);
            case '5' -> doType(KeyEvent.VK_5);
            case '6' -> doType(KeyEvent.VK_6);
            case '7' -> doType(KeyEvent.VK_7);
            case '8' -> doType(KeyEvent.VK_8);
            case '9' -> doType(KeyEvent.VK_9);
            case '-' -> doType(KeyEvent.VK_MINUS);
            case '=' -> doType(KeyEvent.VK_EQUALS);
            case '~' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_QUOTE);
            case '!' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_1);
            case '@' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_2);
            case '#' -> doType(KeyEvent.VK_NUMBER_SIGN);
            case '$' -> doType(KeyEvent.VK_DOLLAR);
            case '%' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_5);
            case '^' -> doType(KeyEvent.VK_CIRCUMFLEX);
            case '&' -> doType(KeyEvent.VK_AMPERSAND);
            case '*' -> doType(KeyEvent.VK_ASTERISK);
            case '(' -> doType(KeyEvent.VK_LEFT_PARENTHESIS);
            case ')' -> doType(KeyEvent.VK_RIGHT_PARENTHESIS);
            case '_' -> doType(KeyEvent.VK_UNDERSCORE);
            case '+' -> doType(KeyEvent.VK_PLUS);
            case '\t' -> doType(KeyEvent.VK_TAB);
            case '\n' -> doType(KeyEvent.VK_ENTER);
            case '[' -> doType(KeyEvent.VK_OPEN_BRACKET);
            case ']' -> doType(KeyEvent.VK_CLOSE_BRACKET);
            case '\\' -> doType(KeyEvent.VK_BACK_SLASH);
            case '{' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_OPEN_BRACKET);
            case '}' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_CLOSE_BRACKET);
            case '|' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_SLASH);
            case ';' -> doType(KeyEvent.VK_SEMICOLON);
            case ':' -> doType(KeyEvent.VK_COLON);
            case '\'' -> doType(KeyEvent.VK_QUOTE);
            case '"' -> doType(KeyEvent.VK_QUOTEDBL);
            case ',' -> doType(KeyEvent.VK_COMMA);
            case '<' -> doType(KeyEvent.VK_LESS);
            case '.' -> doType(KeyEvent.VK_PERIOD);
            case '>' -> doType(KeyEvent.VK_GREATER);
            case '/' -> doType(KeyEvent.VK_SLASH);
            case '?' -> doType(KeyEvent.VK_SHIFT, KeyEvent.VK_SLASH);
            case ' ' -> doType(KeyEvent.VK_SPACE);
            default -> throw new IllegalArgumentException("Cannot type character " + character);
        }
    }

    protected void enter() {
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    protected void doClick(int mouseCode) {
        try {
            robot.mousePress(mouseCode);
            robot.mouseRelease(mouseCode);
        } catch (Exception e) {
            System.out.println("Invalid key code(s) for above character");
        }
    }

    protected void insertString(String str) {
        StringSelection selection = new StringSelection(str);
        clipboard.setContents(selection, selection);
    }

}

abstract class AssistantState{

    protected static Gson g = new Gson();

    protected String getVarVal(String varStr){

    }

    abstract void doAction(Assistant ass, String str);
}

class PuTTY extends AssistantState {

    private String username = "alachanc";
    private String password = "Waffls123456789";
    private String serverString = "burrow.luddy.indiana.edu";
    private String s = "C:\\Program Files\\PuTTY\\putty.exe -ssh -l " + username + " -pw " + password + " " + serverString + "";

    private void login() throws InterruptedException, AWTException {
        Runtime r = Runtime.getRuntime();
        Process p;

        try {
            //open the putty session with the above given username, password and server
            p = r.exec(s);
            Thread.sleep(3000);

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();

        }
        Thread.sleep(2000);

    }

    @Override
    public void doAction(Assistant ass, String str) {
        if(str.equals("Login")){
            try {
                login();
            } catch (InterruptedException | AWTException e) {
                e.printStackTrace();
            }
            ass.robot.keyPress(KeyEvent.VK_1);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ass.robot.keyPress(KeyEvent.VK_ENTER);
        }
    }

}

class Linux extends AssistantState {

    private String commandsFile = "LinuxCommands.json";
    private HashMap<String , ArrayList<String>> commands;

    Linux(){
        try {
            JsonObject j = g.fromJson(new FileReader(commandsFile), JsonObject.class);
            Type type = new TypeToken<Map<String, String>>(){}.getType();
            commands = g.fromJson(j, type);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    @Override
    public void doAction(Assistant ass, String str) {
        String command = commands.get(str).get(0);
        ass.insertString(command);
        ass.doClick(MouseEvent.BUTTON3_DOWN_MASK);
    }

//    public void updateFile() throws IOException {
//        Writer writer = new FileWriter(commandsFile);
//        g.toJson(jsonData, writer);
//        writer.close();
//    }

}

class Emacs extends AssistantState {

    private String commandsFile = "EmacsCommands.json";
    private HashMap<String , ArrayList<Integer>> commands;

    Emacs(){
        try {
            JsonObject j = g.fromJson(new FileReader(commandsFile), JsonObject.class);
            Type type = new TypeToken<Map<String, ArrayList<Integer>>>(){}.getType();
            commands = g.fromJson(j, type);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    //Needs to be adjusted for odd command sequences
    @Override
    public void doAction(Assistant ass, String searchStr) {
        ArrayList<Integer> arr= commands.get(searchStr);

    }

//    public void updateFile() throws IOException {
//        Writer writer = new FileWriter(commandsFile);
//        g.toJson(jsonData, writer);
//        writer.close();
//    }
}
