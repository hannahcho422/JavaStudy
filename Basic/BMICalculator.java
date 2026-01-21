public class BMICalculator {

    public void calculateBMI(BMI bmiObj) {
        double weight = bmiObj.getWeight();
        double height = bmiObj.getHeight();

        double bmi = weight / (height * height);
        bmiObj.setBMI(bmi);

        if (bmi < 18.5) {
            bmiObj.setStatus("Underweight");
        } else if (bmi < 25.0) {
            bmiObj.setStatus("Normal");
        } else if (bmi < 30.0) {
            bmiObj.setStatus("Overweight");
        } else {
            bmiObj.setStatus("Obese");
        }
    }
}