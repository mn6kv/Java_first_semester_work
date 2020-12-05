package ru.itis.util;

import ru.itis.repositories.CallsRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CallsUtil {

    CallsRepository callsRepository;

    public CallsUtil(CallsRepository callsRepository) {
        this.callsRepository = callsRepository;
    }

    public static boolean checkNumber(String number) {
        Pattern regex = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
        Matcher matcher = regex.matcher(number);
        return matcher.find();
    }

    public void addNumber(String number) {
        callsRepository.addNumber(number);
    }
}
