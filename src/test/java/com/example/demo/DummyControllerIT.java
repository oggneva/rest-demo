package com.example.demo;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RunWith(SpringRunner.class)
@WebMvcTest(DummyController.class)
public class DummyControllerIT {

	@Autowired
	private MockMvc mvc;

	@Test
	public void test() throws Exception {
		mvc.perform(get("/dummy").queryParam("thing", "waaaaaaaat").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print());
	}
}

@RestController
@RequestMapping
class DummyController {

	@Autowired
	private SomeService someService;

	@RequestMapping("/dummy")
	public ResponseEntity<String> dummy(@RequestParam(value = "thing", defaultValue = "epico") String thing) {
		return new ResponseEntity<>(thing + " - " + someService.doSomeThing(), HttpStatus.OK);
	}
}
