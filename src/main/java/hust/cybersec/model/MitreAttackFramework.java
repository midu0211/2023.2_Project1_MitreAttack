package hust.cybersec.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import hust.cybersec.collector.dataGetter;

import java.net.URISyntaxException;

/**
 * Represents the Mitre Attack Framework class.
 */
@JsonDeserialize(using = Deserializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MitreAttackFramework {
    private String techniqueId;

    @JsonProperty("name")
    private String techniqueName;

    @JsonProperty("description")
    private String techniqueDescription;

    @JsonProperty("x_mitre_platforms")
    private String[] techniquePlatforms;

    @JsonProperty("x_mitre_domains")
    private String[] techniqueDomains;

    private String techniqueUrl;

    private String[] techniqueTactics;

    @JsonProperty("x_mitre_detection")
    private String techniqueDetection;

    @JsonProperty("x_mitre_is_subtechnique")
    private boolean techniqueIsSubtechnique;

    /**
     * Default constructor for the MitreAttackFramework class.
     */
    public MitreAttackFramework() {

    }

    /**
     * Constructor for the MitreAttackFramework class.
     *
     * @param techniqueId             The ID of the technique.
     * @param techniqueName           The name of the technique.
     * @param techniqueDescription    The description of the technique.
     * @param techniquePlatforms      The platforms associated with the technique.
     * @param techniqueDomains        The domains associated with the technique.
     * @param techniqueUrl            The URL of the technique.
     * @param techniqueTactics        The tactics associated with the technique.
     * @param techniqueDetection      The detection information for the technique.
     * @param techniqueIsSubtechnique Indicates if the technique is a subtechnique.
     */
    public MitreAttackFramework(String techniqueId, String techniqueName, String techniqueDescription,
                                String[] techniquePlatforms, String[] techniqueDomains, String techniqueUrl, String[] techniqueTactics,
                                String techniqueDetection, boolean techniqueIsSubtechnique) {
        this.techniqueId = techniqueId;
        this.techniqueName = techniqueName;
        this.techniqueDescription = techniqueDescription;
        this.techniquePlatforms = techniquePlatforms;
        this.techniqueDomains = techniqueDomains;
        this.techniqueUrl = techniqueUrl;
        this.techniqueTactics = techniqueTactics;
        this.techniqueDetection = techniqueDetection;
        this.techniqueIsSubtechnique = techniqueIsSubtechnique;
    }

    // Getter and Setter
    public String getTechniqueId() {
        return techniqueId;
    }

    public String getTechniqueName() {
        return techniqueName;
    }

    public void setTechniqueId(String techniqueId) {
        this.techniqueId = techniqueId;
    }

    public void setTechniqueName(String techniqueName) {
        this.techniqueName = techniqueName;
    }

    public void setTechniqueDescription(String techniqueDescription) {
        this.techniqueDescription = techniqueDescription;
    }

    public void setTechniquePlatforms(String[] techniquePlatforms) {
        this.techniquePlatforms = techniquePlatforms;
    }

    public void setTechniqueDomains(String[] techniqueDomains) {
        this.techniqueDomains = techniqueDomains;
    }

    public void setTechniqueUrl(String techniqueUrl) {
        this.techniqueUrl = techniqueUrl;
    }

    public void setTechniqueTactics(String[] techniqueTactics) {
        this.techniqueTactics = techniqueTactics;
    }

    public void setTechniqueDetection(String techniqueDetection) {
        this.techniqueDetection = techniqueDetection;
    }

    public void setTechniqueIsSubtechnique(boolean techniqueIsSubtechnique) {
        this.techniqueIsSubtechnique = techniqueIsSubtechnique;
    }

    public String getTechniqueDescription() {
        return techniqueDescription;
    }

    public String[] getTechniquePlatforms() {
        return techniquePlatforms;
    }

    public String[] getTechniqueDomains() {
        return techniqueDomains;
    }

    public String getTechniqueUrl() {
        return techniqueUrl;
    }

    public String[] getTechniqueTactics() {
        return techniqueTactics;
    }

    public String getTechniqueDetection() {
        return techniqueDetection;
    }

    /**
     * Checks if the technique is a subtechnique.
     *
     * @return True if the technique is a subtechnique, false otherwise.
     */
    public void download() throws URISyntaxException {
        final String ATOMIC_URL = "https://api.github.com/repos/redcanaryco/atomic-red-team/contents/atomics/Indexes/index.yaml";
        final String NAME_FILE = "index.yaml";
        dataGetter atomicRetriever = new dataGetter(ATOMIC_URL, NAME_FILE);

        try {
            atomicRetriever.retrieveData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



        public boolean isTechniqueIsSubtechnique() {
        return techniqueIsSubtechnique;
    }
}


