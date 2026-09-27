    // Port of test/Main.js.
    public static Object deferEff = (java.util.function.Function<Object, Object>) (thunk) ->
        (java.util.function.Supplier<Object>) () ->
            ((java.util.function.Function<Object, Object>) thunk).apply(null);

    public static Object arrayFrom1UpTo = (java.util.function.Function<Object, Object>) (n) -> {
        int count = ((Number) n).intValue();
        Object[] result = new Object[Math.max(0, count)];
        for (int i = 1; i <= count; i++) result[i - 1] = i;
        return result;
    };

    public static Object arrayReplicate = (java.util.function.Function<Object, Object>) (n) ->
        (java.util.function.Function<Object, Object>) (x) -> {
            int count = ((Number) n).intValue();
            Object[] result = new Object[Math.max(0, count)];
            java.util.Arrays.fill(result, x);
            return result;
        };

    public static Object mkNEArray = (java.util.function.Function<Object, Object>) (nothing) ->
        (java.util.function.Function<Object, Object>) (just) ->
        (java.util.function.Function<Object, Object>) (arr) -> {
            Object[] array = (Object[]) arr;
            return array.length > 0
                ? ((java.util.function.Function<Object, Object>) just).apply(array)
                : nothing;
        };

    public static Object foldMap1NEArray = (java.util.function.Function<Object, Object>) (append) ->
        (java.util.function.Function<Object, Object>) (f) ->
        (java.util.function.Function<Object, Object>) (arr) -> {
            Object[] array = (Object[]) arr;
            Object acc = ((java.util.function.Function<Object, Object>) f).apply(array[0]);
            for (int i = 1; i < array.length; i++) {
                acc = ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) append).apply(acc))
                    .apply(((java.util.function.Function<Object, Object>) f).apply(array[i]));
            }
            return acc;
        };
