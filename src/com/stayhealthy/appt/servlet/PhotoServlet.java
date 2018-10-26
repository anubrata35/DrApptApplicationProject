package com.stayhealthy.appt.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.stayhealthy.appt.model.DrDetailsModel;

@WebServlet("/PhotoServlet")
public class PhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PhotoServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		DrDetailsModel model = null;
		@SuppressWarnings("unchecked")
		List<DrDetailsModel> drDetails = (ArrayList<DrDetailsModel>) session.getAttribute("drDetails");
		if (drDetails != null && drDetails.size() > 0)
			model = drDetails.get(0);

		byte[] blob = null;
		if (model != null && model.getProfilePicture() != null) {
			blob = model.getProfilePicture();
		} else {
			InputStream inputStream = (InputStream) getServletContext()
					.getResourceAsStream("./img/doctor-profile-image.jpg");
			blob = getBytesFromInputStream(inputStream);
		}
		OutputStream out = response.getOutputStream();
		response.setContentType(model.getContentType());
		out.write(blob);
		out.flush();
		out.close();

	}

	public static byte[] getBytesFromInputStream(InputStream in) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int next = in.read();
		while (next > -1) {
			bos.write(next);
			next = in.read();
		}
		bos.flush();
		byte[] result = bos.toByteArray();

		return result;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
