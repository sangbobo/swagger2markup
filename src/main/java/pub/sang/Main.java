package pub.sang;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by 桑博 on 2017/9/15.
 */
public class Main {

    public static void main(String[] args) throws MalformedURLException {
//        URL url = new URL("http://xx.xx.xx.xx:8080/xx/v2/api-docs");
        Path inputFile = Paths.get("src/main/resources/swagger.json");
        Path outputFile = Paths.get("build/swagger");
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();
//        Swagger2MarkupConverter converter = Swagger2MarkupConverter.from(url)
        Swagger2MarkupConverter converter = Swagger2MarkupConverter.from(inputFile)
                .withConfig(config)
                .build();
        converter.toFile(outputFile);
    }

}
