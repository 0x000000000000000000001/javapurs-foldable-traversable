public final class __Record$66_6f_6c_64_61_62_6c_65_2d_74_72_61_76_65_72_73_61_62_6c_65_O extends java.util.AbstractMap<String, Object> {
    private final String[] __order;
    public final Object field0;
    __Record$66_6f_6c_64_61_62_6c_65_2d_74_72_61_76_65_72_73_61_62_6c_65_O(String[] order, Object field0) {
        this.__order = order;
        this.field0 = field0;
    }
    public static __Record$66_6f_6c_64_61_62_6c_65_2d_74_72_61_76_65_72_73_61_62_6c_65_O copy(__Record$66_6f_6c_64_61_62_6c_65_2d_74_72_61_76_65_72_73_61_62_6c_65_O original, Object field0) {
        return new __Record$66_6f_6c_64_61_62_6c_65_2d_74_72_61_76_65_72_73_61_62_6c_65_O(original.__order, field0);
    }
    public static Object read0(Object value) {
        if (value instanceof __Record$66_6f_6c_64_61_62_6c_65_2d_74_72_61_76_65_72_73_61_62_6c_65_O) return ((__Record$66_6f_6c_64_61_62_6c_65_2d_74_72_61_76_65_72_73_61_62_6c_65_O) value).field0;
        return ((java.util.Map<?, ?>) value).get("foldable-traversable");
    }
    @Override public Object get(Object key) {
        if ("foldable-traversable".equals(key)) return field0;
        return null;
    }
    @Override public boolean containsKey(Object key) { return "foldable-traversable".equals(key); }
    @Override public int size() { return 1; }
    @Override public java.util.Set<java.util.Map.Entry<String, Object>> entrySet() {
        java.util.LinkedHashSet<java.util.Map.Entry<String, Object>> entries = new java.util.LinkedHashSet<>();
        for (String key : __order) entries.add(new java.util.AbstractMap.SimpleImmutableEntry<>(key, get(key)));
        return java.util.Collections.unmodifiableSet(entries);
    }
}
