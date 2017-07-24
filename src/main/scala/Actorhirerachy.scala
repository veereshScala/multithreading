/*
 * this class is for actor hierarchy
 * 
 */
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef
object Actorhirerachy extends App {
  case object createchild
  case object printsignal
  case object signalchild
  class simpleActorparent extends Actor{
   private var num=0
   private val child=scala.collection.mutable.Buffer[ActorRef]()
    def receive={
    case createchild=>
      child+= context.actorOf(Props[simpleActorchild],"child"+num)
       num+=1    
    case signalchild=>
      child.foreach(_ ! printsignal)
   }
  
}

   class simpleActorchild extends Actor{
  def receive={
    
   case printsignal =>println(self)
    
  }
  def normalmethod=println("normal method")
//to make the system 
}
  
  val system=ActorSystem("actorhiereachy")
  val actorparent=system.actorOf(Props[simpleActorparent],"actorHier")
  
  actorparent ! createchild
  actorparent ! signalchild
  actorparent ! createchild
  actorparent ! createchild
  actorparent ! signalchild
  actorparent ! createchild
  system.shutdown()
}