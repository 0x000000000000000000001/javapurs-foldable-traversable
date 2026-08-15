    public static Object foldrArray = (java.util.function.Function<Object, Object>) (f) -> (java.util.function.Function<Object, Object>) (init) -> (java.util.function.Function<Object, Object>) (xs) -> {
        Object acc = init;
        Object[] arr = (Object[]) xs;
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            acc = ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) f).apply(arr[i])).apply(acc);
        }
        return acc;
    };

    public static Object foldlArray = (java.util.function.Function<Object, Object>) (f) -> (java.util.function.Function<Object, Object>) (init) -> (java.util.function.Function<Object, Object>) (xs) -> {
        Object acc = init;
        Object[] arr = (Object[]) xs;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            acc = ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) f).apply(acc)).apply(arr[i]);
        }
        return acc;
    };
