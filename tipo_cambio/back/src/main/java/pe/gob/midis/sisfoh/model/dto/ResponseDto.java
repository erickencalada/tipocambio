package pe.gob.midis.sisfoh.model.dto;

public class ResponseDto<T> {
	
	private int httpStatus;
	private Response response;
	private T payLoad;
	

	public ResponseDto() {
		super();
	}

	public ResponseDto(int httpStatus, Response response, T payLoad) {
		super();
		this.httpStatus = httpStatus;
		this.response = response;
		this.payLoad = payLoad;
	}
	
	public int getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	public T getPayLoad() {
		return payLoad;
	}
	public void setPayLoad(T payLoad) {
		this.payLoad = payLoad;
	}

}
