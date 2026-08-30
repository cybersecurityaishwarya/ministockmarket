//package WebSocketController;
//
//import java.util.List;
//
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.stock.DataTransferObject.TrendingStock;
//
//@Controller
//
//public class WebSocketController {
//	private final SimpMessagingTemplate messaging;
//	public WebSocketController( SimpMessagingTemplate messaging) {
//		this.messaging=messaging;
//	}
//	@PostMapping("/api/stock/trending")
//	public void sendTrendingStock (@RequestBody List<TrendingStock> stocks){
//		messaging.convertAndSend("/topic/public",stocks);
//	}
//}
