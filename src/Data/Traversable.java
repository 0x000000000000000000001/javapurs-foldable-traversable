    // Mirrors the JavaScript balanced traversal: the helper functions build
    // single-element arrays and concatenate two arrays.
    private static Object $array1 = (java.util.function.Function<Object, Object>) (a) -> new Object[]{ a };

    private static Object $array2 = (java.util.function.Function<Object, Object>) (a) ->
        (java.util.function.Function<Object, Object>) (b) -> new Object[]{ a, b };

    private static Object $array3 = (java.util.function.Function<Object, Object>) (a) ->
        (java.util.function.Function<Object, Object>) (b) ->
        (java.util.function.Function<Object, Object>) (c) -> new Object[]{ a, b, c };

    private static Object $concat2 = (java.util.function.Function<Object, Object>) (xs) ->
        (java.util.function.Function<Object, Object>) (ys) -> {
            Object[] left = (Object[]) xs;
            Object[] right = (Object[]) ys;
            Object[] combined = new Object[left.length + right.length];
            System.arraycopy(left, 0, combined, 0, left.length);
            System.arraycopy(right, 0, combined, left.length, right.length);
            return combined;
        };

    private static Object $traverseGo(Object apply, Object map, Object pure, Object f, Object[] array, int bot, int top) {
        switch (top - bot) {
            case 0:
                return ((java.util.function.Function<Object, Object>) pure).apply(new Object[0]);
            case 1:
                return ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) map).apply($array1)).apply(
                    ((java.util.function.Function<Object, Object>) f).apply(array[bot]));
            case 2:
                return ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) apply).apply(
                    ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) map).apply($array2)).apply(
                        ((java.util.function.Function<Object, Object>) f).apply(array[bot])))).apply(
                    ((java.util.function.Function<Object, Object>) f).apply(array[bot + 1]));
            case 3:
                return ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) apply).apply(
                    ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) apply).apply(
                        ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) map).apply($array3)).apply(
                            ((java.util.function.Function<Object, Object>) f).apply(array[bot])))).apply(
                        ((java.util.function.Function<Object, Object>) f).apply(array[bot + 1])))).apply(
                    ((java.util.function.Function<Object, Object>) f).apply(array[bot + 2]));
            default:
                int pivot = bot + ((top - bot) / 4) * 2;
                return ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) apply).apply(
                    ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) map).apply($concat2)).apply(
                        $traverseGo(apply, map, pure, f, array, bot, pivot)))).apply(
                    $traverseGo(apply, map, pure, f, array, pivot, top));
        }
    }

    public static Object traverseArrayImpl = (java.util.function.Function<Object, Object>) (apply) ->
        (java.util.function.Function<Object, Object>) (map) ->
        (java.util.function.Function<Object, Object>) (pure) ->
        (java.util.function.Function<Object, Object>) (f) ->
        (java.util.function.Function<Object, Object>) (array) -> {
            Object[] items = (Object[]) array;
            return $traverseGo(apply, map, pure, f, items, 0, items.length);
        };
