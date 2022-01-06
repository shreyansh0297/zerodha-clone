package com.cg.zerodhaclone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

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
import com.cg.zerodhaclone.repository.ISharesRepository;
import com.cg.zerodhaclone.service.SharesServiceImpl;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ShareTest {

	@Mock
	private ISharesRepository shareRepo;

	@InjectMocks
	private SharesServiceImpl shareService;

	@BeforeEach
	void setUp() throws Exception
	{
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
    public void addShares()
    {
		Shares share = new Shares(1L,5,"INFY",LocalDate.now(),2422);
		
		Mockito.when(shareRepo.save(share)).thenReturn(share);
	    assertEquals(share, shareService.addNewShares(share));	
    }
	
	@Test
	public void attachTrader() {
		Trader trader = new Trader(1L,"SL",LocalDate.parse("1989-05-05"),"sl@gmail.com","1234",
				"9876543210",Role.TRADER);
		Shares share = new Shares(10000L,5,"INFY",LocalDate.now(),2422);
		
		Mockito.when(shareRepo.getById(10000L)).thenReturn(share);
		assertEquals(share,shareService.attachTrader(1L, share));
		
	}
}
