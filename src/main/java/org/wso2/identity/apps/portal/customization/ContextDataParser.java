package org.wso2.identity.apps.portal.customization;

import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ContextDataParser {

    private static final Log log = LogFactory.getLog(ContextDataParser.class);

    public static String parse(Map<String, Object> data, String htmlContent, String defaultContent) {

        if (htmlContent == null || htmlContent.isEmpty()) {
            log.warn("Received empty HTML content, falling back to default template.");
            return defaultContent;
        }

        StringBuilder result = new StringBuilder();
        int startIdx = 0;

        while ((startIdx = htmlContent.indexOf("{{", startIdx)) != -1) {
            result.append(htmlContent, 0, startIdx);

            int endIdx = htmlContent.indexOf("}}", startIdx);
            if (endIdx == -1) {
                break; // Unmatched placeholder, skip replacement
            }

            String key = htmlContent.substring(startIdx + 2, endIdx).trim();
            String replacement = (String) data.getOrDefault(key, "<!-- Missing: " + key + " -->");

            result.append(replacement);
            htmlContent = htmlContent.substring(endIdx + 2);
        }

        result.append(htmlContent); // Append remaining content
        return result.toString();
    }
}

