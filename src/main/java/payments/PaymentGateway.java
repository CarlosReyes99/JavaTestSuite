package payments;

public interface PaymentGateway {


    //Método de solicitar pago,  de pago y recibe
    PaymentResponse requestPayment(PaymentRequest request);
}
