package com.pedorenko;

import com.pedorenko.html_parser.HTMLParser;
import com.pedorenko.matcher.Matcher;
import com.pedorenko.matcher.MatchingParams;
import org.jsoup.nodes.Element;
import java.io.File;
import java.util.Optional;

public class App {


    private static final String TARGET_ELEMENT_ID = "make-everything-ok-button";

    private static String CHARSET_NAME = "utf8";

    public static void main(String[] args) {

        String inputOriginFilePath = args[0];
        String inputOtherSampleFilePath = args[1];

        Optional<Element> buttonOpt = HTMLParser.findElementById(new File(inputOriginFilePath), CHARSET_NAME, TARGET_ELEMENT_ID);
        if (!buttonOpt.isPresent()) {
            System.out.println("Element not found by id=" + TARGET_ELEMENT_ID);
            return;
        }

        MatchingParams matchingParams = Matcher.defineMatchingParams(buttonOpt.get());

        Optional<Element> mostMatchingElementOpt = Matcher.findMostMatchingElement(new File(inputOtherSampleFilePath), CHARSET_NAME, matchingParams);
        if (!mostMatchingElementOpt.isPresent()) {
            System.out.println("Not found any matching element");
            return;
        }

        Element mostMatchingElement = mostMatchingElementOpt.get();

        String pathToMostMatchingElement = HTMLParser.getPathToElementFormatted(mostMatchingElement);
        System.out.println(pathToMostMatchingElement);
    }

}
