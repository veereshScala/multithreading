import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
object Actorexaple extends App{
class simpleActorexample extends Actor{
  def receive={
    case s:String=> println("String: "+s)
    case i:Int=>println("Int:"+i)
    
  }
  def normalmethod=println("normal method")
//to make the system 
}
  val system=ActorSystem("simplesystem")
  //create an actor as its a case class
  val actor=system.actorOf(Props[simpleActorexample],"simpleActor")
  //to send a message we call it as actor bang 
  println("befor actor sends messages")
  actor ! "Hi there"
  actor ! 442
  println("after actor sends messages")
  actor ! 'v'
  println("after char")
//note the system is not terminated in order to make it pass a shutdown message 
  system.shutdown()
  //in general the system is deprecated it means other actor messages are waiting
 //how actors communicate with each other 
  
}