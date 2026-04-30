class TimeMap {

    public record ValueRecord(String value, int timestamp) {};
    Map<String, List<ValueRecord>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        ValueRecord val = new ValueRecord(value, timestamp);
        List<ValueRecord> values = map.getOrDefault(key, new ArrayList<>());
        values.add(val);
        map.put(key, values);
    }
    
    public String get(String key, int timestamp) {
        List<ValueRecord> values = map.get(key);
        return find(values, timestamp);
    }

    private String find(List<ValueRecord> values, int timestamp) {
        String result = "";
        if (values == null) return result;
        int l = 0, r = values.size() - 1;
        while (l <= r) {
            int m = (l+r)/2;
            ValueRecord val = values.get(m);
            if (val.timestamp <= timestamp) {
                result = val.value;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return result;
    }
}
