package activities;

 class MyBook extends  Book {

    public void setTitle(String s) {
        title = s;
    }

}
    public class Activity5 {



    public static void main(String[] args) {
        Book newNovel = new MyBook();
        newNovel.setTitle("Learn Java");
        System.out.println("Title of the book is "+newNovel.getTitle());
    }
}
