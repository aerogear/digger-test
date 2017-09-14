package org.aerogear.digger.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.json.JSONObject;

@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "templateId")
@ToString
public class Template {

    private String templateId;
    private String templateName;
    private String repoUrl;
    private String repoBranch;

    public Template(JSONObject jsonTemplate) {
        this(
                jsonTemplate.getString("id"),
                jsonTemplate.getString("name"),
                jsonTemplate.getString("repoUrl"),
                jsonTemplate.getString("repoBranch")
        );
    }

}
