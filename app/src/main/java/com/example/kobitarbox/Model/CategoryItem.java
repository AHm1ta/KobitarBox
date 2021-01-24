package com.example.kobitarbox.Model;


public class CategoryItem {
    private String CategoryName;
    private String PoemName;
    private String WriterName;
    private int Poem;
    private int image;


    public CategoryItem(String categoryName, String poemName, String writerName, int poem, int image) {
        this.CategoryName = categoryName;
        this.PoemName = poemName;
        this.WriterName = writerName;
        this.Poem = poem;
        this.image = image;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public String getPoemName() {
        return PoemName;
    }

    public String getWriterName() {
        return WriterName;
    }

    public int getPoem() {
        return Poem;
    }

    public int getImage() {
        return image;
    }
}
