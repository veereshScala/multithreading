
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import scala.concurrent.duration._

object schedulerexample extends App{
  case object count
  class simpleapp extends Actor{
    private var n=0
    def receive={
      
      case count=>
        {n=n+1
          println(n)
        }
        }
  
  }
  val system=ActorSystem("system")
  val actor=system.actorOf(Props[simpleapp],"scheduler")
implicit val ec=system.dispatcher
  actor ! count
  //to make it happen multiple times 
  system.scheduler.scheduleOnce(1.second)(actor ! count)
  
  system.scheduler.schedule(1.second, 100.millisecond,actor,count)
  Thread.sleep(1000)
  system.shutdown()
}