package com.cg.zerodhaclone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cg.zerodhaclone.entities.Role;
import com.cg.zerodhaclone.entities.Shares;
import com.cg.zerodhaclone.entities.Trader;
import com.cg.zerodhaclone.repository.ITraderRepository;
import com.cg.zerodhaclone.service.ITraderService;
import com.cg.zerodhaclone.service.TraderServiceImpl;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TraderTest {

	@Mock
	private ITraderRepository traderRepo;

	@InjectMocks
	private TraderServiceImpl traderService;

	@BeforeEach
	void setUp() throws Exception
	{
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
    public  void createTraderTest()
    {
		Shares share = new Shares(1L,5,"TCS",LocalDate.now(),2422);
		List<Shares> shareList = new ArrayList<Shares>();
		shareList.add(share);
		Trader trader = new Trader(9000,shareList,"ABCDE1234F");
		
		Mockito.when(traderRepo.save(trader)).thenReturn(trader);
	    assertEquals(trader, traderService.addTrader(trader));	
    }
	
	@Test
	public void updateTraderTest() {
		Trader trader = new Trader(1L,"SL",LocalDate.parse("1989-05-05"),"sl@gmail.com","1234",
				"9876543210",Role.TRADER);
		trader.setBalance(9000);
		trader.setPanCard("ABCDE1234F");
		
		Mockito.when(traderRepo.getById(1L)).thenReturn(trader);
		assertEquals(trader,traderService.updateTrader(1L, trader));
		
		
	}
}
