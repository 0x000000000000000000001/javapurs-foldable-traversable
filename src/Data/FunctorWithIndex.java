    public static Object mapWithIndexArray = (java.util.function.Function<Object, Object>) (f) ->
        (java.util.function.Function<Object, Object>) (xs) -> {
            Object[] items = (Object[]) xs;
            Object[] result = new Object[items.length];
            for (int i = 0; i < items.length; i++) {
                result[i] = ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) f).apply(i)).apply(items[i]);
            }
            return result;
        };
