/*
 * design pattern called Ask used in Akka
 */
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef
import akka.pattern._
//to make timeout 
import scala.concurrent.duration
import akka.util.Timeout
import scala.concurrent.ExecutionContext.Implicits.global
object askPatterns extends App{
  case object Askname
  case class nameresponse(name:String)

class AskPatterns(name:String) extends Actor {
   def receive={
     
     case Askname=>sender! nameresponse(name)
  }

}
val system=ActorSystem("asksystem")
val actor=system.actorOf(Props(new AskPatterns("veeresh")),"askpatternexample")


//implicit val timerout=Timeout(1.seconds)
actor ! Askname


system.shutdown()

}