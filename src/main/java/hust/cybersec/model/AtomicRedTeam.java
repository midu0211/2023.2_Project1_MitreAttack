package hust.cybersec.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import hust.cybersec.collector.dataGetter;
import hust.cybersec.conversion.YamlToJsonConverter;

import java.net.URISyntaxException;


/**
 * Represents the Atomic Red Team class, extending the MitreAttackFramework.
 * Provides functionality related to Atomic Red Team tests.
 */
public class AtomicRedTeam extends MitreAttackFramework {
    private int testNumber;

    @JsonProperty("name")
    private String testName;

    @JsonProperty("auto_generated_guid")
    private String testGuid;

    @JsonProperty("description")
    private String testDescription;

    @JsonProperty("supported_platforms")
    private String[] testSupportedPlatforms;

    @JsonProperty("input_arguments")
    private String[] testInputArguments;

    @JsonProperty("executor")
    private String[] testExecutor;

    @JsonProperty("dependency_executor_name")
    private String testDependencyExecutorName;

    @JsonProperty("dependencies")
    private String[] testDependencies;

    /**
     * Default constructor for the AtomicRedTeam class.
     * Initializes the class with default values.
     */
    public AtomicRedTeam() {
        super();
    }

    /**
     * Constructor for the AtomicRedTeam class.
     *
     * @param testName                   The name of the test.
     * @param testGuid                   The auto-generated GUID for the test.
     * @param testDescription            The description of the test.
     * @param testSupportedPlatforms     The supported platforms for the test.
     * @param testInputArguments         The input arguments for the test.
     * @param testExecutor               The executor for the test.
     * @param testDependencyExecutorName The name of the dependency executor.
     * @param testDependencies           The dependencies of the test.
     */
    public AtomicRedTeam(String testName, String testGuid, String testDescription, String[] testSupportedPlatforms,
                         String[] testInputArguments, String[] testExecutor, String testDependencyExecutorName,
                         String[] testDependencies) {
        super();
        this.testName = testName;
        this.testGuid = testGuid;
        this.testDescription = testDescription;
        this.testSupportedPlatforms = testSupportedPlatforms;
        this.testInputArguments = testInputArguments;
        this.testExecutor = testExecutor;
        this.testDependencyExecutorName = testDependencyExecutorName;
        this.testDependencies = testDependencies;
    }

    /**
     * Constructor for the AtomicRedTeam class.
     *
     * @param testNumber                 The number of the test.
     * @param testName                   The name of the test.
     * @param testGuid                   The auto-generated GUID for the test.
     * @param testDescription            The description of the test.
     * @param testSupportedPlatforms     The supported platforms for the test.
     * @param testInputArguments         The input arguments for the test.
     * @param testExecutor               The executor for the test.
     * @param testDependencyExecutorName The name of the dependency executor.
     * @param testDependencies           The dependencies of the test.
     */
    public AtomicRedTeam(int testNumber, String testName, String testGuid, String testDescription,
                         String[] testSupportedPlatforms, String[] testInputArguments, String[] testExecutor,
                         String testDependencyExecutorName, String[] testDependencies) {
        super();
        this.testNumber = testNumber;
        this.testName = testName;
        this.testGuid = testGuid;
        this.testDescription = testDescription;
        this.testSupportedPlatforms = testSupportedPlatforms;
        this.testInputArguments = testInputArguments;
        this.testExecutor = testExecutor;
        this.testDependencyExecutorName = testDependencyExecutorName;
        this.testDependencies = testDependencies;
    }

    // Setter and  Getter
    public void setTestNumber(int testNumber) {
        this.testNumber = testNumber;
    }

    public int getTestNumber() {
        return testNumber;
    }

    public String getTestName() {
        return testName;
    }

    public String getTestGuid() {
        return testGuid;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public String[] getTestSupportedPlatforms() {
        return testSupportedPlatforms;
    }

    public String[] getTestInputArguments() {
        return testInputArguments;
    }

    public String[] getTestExecutor() {
        return testExecutor;
    }

    public String getTestDependencyExecutorName() {
        return testDependencyExecutorName;
    }

    public String[] getTestDependencies() {
        return testDependencies;
    }

    /**
     * Downloads Atomic Red Team data.
     *
     * @throws URISyntaxException If there is an error in the URI syntax.
     */

    public void download() throws URISyntaxException{
        final String[] MITRE_URL = {"https://api.github.com/repos/mitre-attack/attack-stix-data/contents/enterprise-attack/enterprise-attack.json",
                "https://api.github.com/repos/mitre-attack/attack-stix-data/contents/ics-attack/ics-attack.json",
                "https://api.github.com/repos/mitre-attack/attack-stix-data/contents/mobile-attack/mobile-attack.json"};
        final String[] NAME_FILE = {"enterprise-attack.json",
                "ics-attack.json",
                "mobile-attack.json"};

        for (int i = 0; i < 3; i++){
            dataGetter mitreRetriever = new dataGetter(MITRE_URL[i], NAME_FILE[i]);
            try {
                mitreRetriever.retrieveData();
            } catch( Exception e){
                e.printStackTrace();
            }
        }

        String YAML_FILE_PATH = "src/main/java/hust/cybersec/data/index.yaml";
        String JSON_FILE_PATH = "src/main/java/hust/cybersec/data/index.json";

        YamlToJsonConverter converter = new YamlToJsonConverter(YAML_FILE_PATH, JSON_FILE_PATH);
        converter.convert();

    }
}