package Domain;

public class BusTypeModel{
    private String busTypeId, busTypeName;

    public BusTypeModel() {
    }

    public BusTypeModel(String busTypeId, String busTypeName) {
        this.busTypeId = busTypeId;
        this.busTypeName = busTypeName;
    }

    public String getBusTypeId() {
        return busTypeId;
    }

    public void setBusTypeId(String busTypeId) {
        this.busTypeId = busTypeId;
    }

    public String getBusTypeName() {
        return busTypeName;
    }

    public void setBusTypeName(String busTypeName) {
        this.busTypeName = busTypeName;
    }
    
    
}