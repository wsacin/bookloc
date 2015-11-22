import groovy.ui.GroovySocketServer
import groovy.json.JsonSlurper
import java.net.ServerSocket

def server = new ServerSocket(50008)
def slurper = new JsonSlurper()
 
while(true) {
    server.accept { socket ->
        println "processing new connection..."
        socket.withStreams { input, output ->
            def reader = input.newReader()
            def buffer = reader.readLine()
            println "server received: $buffer"

            def json = slurper.parseText(buffer) 

            //now = new Date()
            //output << "echo-response($now): " + buffer + "\n"
        }
        println "processing/thread complete."
    }
}
