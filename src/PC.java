
import utils.*;

public class PC {
    @DomainConstraint(type = "String",mutable = true,optional = false,length = 20)
    private String model;
    @DomainConstraint(type = "Integer",mutable = false,optional = false,min = 1894)
    private int year;
    @DomainConstraint(type = "String",mutable = false,optional = false,length = 15)
    private String manufacturer;
    @DomainConstraint(type = "Set<String>",mutable = true,optional = false)
    private Set<String> comps;

    public PC(@AttrRef("Model") String model, @AttrRef("Year") int year, @AttrRef("Manufacturer") String manufacturer, @AttrRef("Comps") Set<String> comps ) throws NotPossibleException {
        if (!validateModel(model)) {
            throw new NotPossibleException("Person.init: invalid model: " + model);
        }if (!validateYear(year)) {
            throw new NotPossibleException("Person.init: invalid year: " + year);
        }if (!validateManufacturer(manufacturer)) {
            throw new NotPossibleException("Person.init: invalid manufacturer: " + manufacturer);
        }if (!validateComps(comps)) {
            throw new NotPossibleException("Person.init: invalid components: " + comps);
        }
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.comps = comps;
    }

    private boolean validateModel(String model){
        if (model == null || model.isEmpty()){
            return false;
        }
        if (model.length() > 20){
            return false;
        }
        return true;
    }

    private boolean validateYear(int year){
        if (year < 1894){
            return false;
        }
        return true;
    }

    private boolean validateManufacturer(String manufacturer) {
        if (manufacturer == null || manufacturer.isEmpty()) {
            return false;
        }
        if (manufacturer.length() > 15) {
            return false;
        }
        return true;
    }

    private boolean validateComps(Set<String> comps){
        return true;
    }

    public boolean repOK() {
        if (validateModel(model) && validateYear(year) && validateManufacturer(manufacturer) && validateComps(comps)) {
            return true;
        }
        return false;
    }

    @Override
    @DOpt(type = OptType.Default)
    public boolean equals(Object Pc) {
        if (!( Pc instanceof PC)){
            return false;
        }else {
            PC p = (PC) Pc;
            return true;
        }
    }

    @Override
    @DOpt(type = OptType.Default)
    public String toString() {
        return "PC<" + model + ", " + year + ", " + manufacturer + ", " + comps +">";
    }

    @DOpt(type = OptType.Observer) @AttrRef("Model")
    public String getModel(){
        return model;
    }
    @DOpt(type = OptType.Observer) @AttrRef("Year")
    public int getYear(){
        return year;
    }
    @DOpt(type = OptType.Observer) @AttrRef("Manufacturer")
    public String getManufacturer(){
        return manufacturer;
    }
    @DOpt(type = OptType.Observer) @AttrRef("Comps")
    public Set<String> getComps(){
        return comps;
    }

}
