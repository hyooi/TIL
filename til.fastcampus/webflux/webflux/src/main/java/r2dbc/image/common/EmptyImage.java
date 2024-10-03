package r2dbc.image.common;

import springreactive.springwebflux.image.common.Image;

public class EmptyImage extends Image {
    public EmptyImage() {
        super("", "", "");
    }
}
