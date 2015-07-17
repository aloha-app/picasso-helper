picasso-helper
==============

Helper class for picasso, support alternate mirror url list .

API
----

```java
PicassoHelper picassoHelper = new PicassoHelper(picasso);
picassoHelper.load("image-key", imageUrl,
        Arrays.asList(imageUrl2, imageUrl3, imageUrl4))
    .into(imageView);
```

Maven
-----


Gradle
_____

