object ParCol{
  def main(args: Array[String]) {
    (1 to 5).foreach(println);
    (1 to 5).par.foreach(println); 
  }
}