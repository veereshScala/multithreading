import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef

object Actorcountdowns extends App {
  case class startcounting(n:Int,Other:ActorRef)
  case class countdown1(n:Int)
  class countdown extends Actor{

  def receive={
    //in genral never use the builtin 
    //suppose to define case classes 
    case startcounting(n,other)=> println(n)
    other ! (countdown1(n+1))
    case(countdown1(n))=>
      println(self)//self ==this of scala 
      if(n<10){
        println(n)
      sender ! countdown1(n+1)
      }else{
        context.system.shutdown()
      }
    
  }
  def normalmethod=println("normal method")
//to make the system 
}

   val system=ActorSystem("simplesystem")
   val actor1=system.actorOf(Props[countdown],"actorscommunicate1")
   val actor2=system.actorOf(Props[countdown],"actorscommunicate2")
   actor1 ! startcounting(0,actor2)
   
   system.shutdown()
}