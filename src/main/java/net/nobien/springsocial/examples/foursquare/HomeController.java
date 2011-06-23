/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.nobien.springsocial.examples.foursquare;

import java.util.List;

import javax.inject.Inject;

import org.springframework.social.foursquare.api.Foursquare;
import org.springframework.social.foursquare.api.Venue;
import org.springframework.social.foursquare.api.VenueSearchParams;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private final Foursquare foursquare;
	
	@Inject
	public HomeController(Foursquare facebook) {
		this.foursquare = facebook;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
	    List<Venue> venues = foursquare.venueOperations().search(new VenueSearchParams().location(40.77, 73.98));
		model.addAttribute("venues", venues);
		return "home";
	}

}