package com.eli.calc.shape.apps;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eli.calc.shape.reports.ShapeCalculationsReports;
import com.eli.calc.shape.service.ws.CalcType;
import com.eli.calc.shape.service.ws.CalculationRequest;
import com.eli.calc.shape.service.ws.CalculationResult;
import com.eli.calc.shape.service.ws.ShapeName;
import com.eli.calc.shape.service.ws.impl.ShapeCalculatorWebServiceImplService;

public class CmdLineShapeCalcApp {

	private static final Logger logger = LoggerFactory.getLogger(CmdLineShapeCalcApp.class);

	private final static String userInputMessage = "\n\nThis sample app is controlled by user input and will persist data\n";
	
	private final static String finalReportMessage = "\n\nNote: You can look for FINAL REPORT at end of run";
	
	private final static String continueMessage = "\n\nPress <ENTER> to continue with app:";
	
	private static String shapes = "";
	static {
		int i=1;
		for (ShapeName shapeName : ShapeName.values()) {
			shapes+=""+(i++)+") " + shapeName.name() + "\n";
		};
	}
	private final static String selectShapeMenu = "\n\nSelect Shape:\n"
												+ "-----------------------------\n"
												+ shapes
												+ "Q: Quit\n"
												+ "-----------------------------\n"
												+ "Enter number:";


	private static String types = "";
	static {
		int i=1;
		for (CalcType calcType : CalcType.values()) {
			types+=""+(i++)+") " + calcType.name() + "\n";
		};
	}
	private final static String selectTypeMenu = "\n\nSelect Calculation:\n"
												+ "-----------------------------\n"
												+ types
												+ "Q: Quit\n"
												+ "-----------------------------\n"
												+ "Enter number:";


	private final static String enterDimMenu = "\n\nEnter a dimenion:";

    private ShapeCalculatorWebService_ShapeCalculatorWebServiceImplPort_Client soapClient;
	
	private final BufferedReader in;

	CmdLineShapeCalcApp(BufferedReader in, URL wsdlURL) {

		this.in = in;

        soapClient = new ShapeCalculatorWebService_ShapeCalculatorWebServiceImplPort_Client(wsdlURL);

		
	}

	public void doIt() {

		selectAction();

	}
	

	private final static String mainMenu = "\n\nSelect Action:\n"
												+ "-----------------------------\n"
												+ "1: Delete All\n"
												+ "2:  Delete All Requests\n"
												+ "3:  Delete All ReSults\n"
												+ "\n"
												+ "4:  View All Requests(not formatted)\n"
												+ "5:  View All ReSults(not formatted)\n"
												+ "6:  View Formatted Report\n"
												+ "\n"
												+ "7:  Request Calculation (Execs it & Reports)\n"
												+ "8:  Only Request Calculation (no exec) \n"
												+ "\n"
												+ "9:  Run Pending Requests (& Report)\n"
												+ "\n"
												+ "Q: Quit\n"
												+ "-----------------------------\n"
												+ "Enter number:";
	private void selectAction() {
		
		String line = "";
		
		for (;;) {

			System.out.print(mainMenu);

			try {
				line=this.in.readLine();
			} catch (IOException e) {
				logger.debug(e.getMessage(),e);
			}

			try {
				if ("1".equals(line)) {
					soapClient.deletePendingRequests();
					soapClient.deleteResults();
					System.out.println("\n\nAll Data Deleted\n\n");
				} else if ("2".equals(line)) {
					soapClient.deletePendingRequests();
					System.out.println("\n\nAll Requests Deleted\n\n");
				} else if ("3".equals(line)) {
					soapClient.deleteResults();
					System.out.println("\n\nAll Results Deleted\n\n");
				} else if ("4".equals(line)) {
					List<CalculationRequest> requests = soapClient.getPendingRequests();
					System.out.println();
					for (CalculationRequest r : requests) { System.out.println(r); }
				} else if ("5".equals(line)) {
					List<CalculationResult> results = soapClient.getCalculatedResults();
					System.out.println();
					for (CalculationResult r : results) { System.out.println(r); }
				} else if ("6".equals(line)) {
					System.out.println("\n\n"
							+ShapeCalculationsReports.formattedResultsReportByShapeByDimension(
									soapClient.getCalculatedResults()));
					System.out.println("\n\n"
							+ShapeCalculationsReports.formattedResultsReportSummary(
									soapClient.getCalculatedResults())
							+ "\n"
							);
				} else if ("7".equals(line)) {
					requestCalculationRunAndReport();
				} else if ("8".equals(line)) {
					requestCalculationOnly();
				} else if ("9".equals(line)) {
					runAndReport();
				} else if ("Q".toLowerCase().equals(line.toLowerCase())) {
					System.exit(0);
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		} // end of for loop
	}
	
	private void requestCalculationRunAndReport() {
		try {
			requestCalculationOnly();
		
			runAndReport();
			
		} catch (IllegalArgumentException e)  { }
		
	}

	private void runAndReport() {
		try {
			System.out.println("\n\n\nFINAL REPORT========================================================\n");
			int calcsRun = soapClient.runPendingRequestsStopOnError();
			System.out.println(
					ShapeCalculationsReports.formattedResultsReportByShapeByDimension(
							soapClient.getCalculatedResults()));
			System.out.println(
					ShapeCalculationsReports.formattedResultsReportSummary(
							soapClient.getCalculatedResults())
					+ "\n"
					+ "calcsRun = " + calcsRun
					);
		} catch (IllegalArgumentException e)  { }
		
	}

	private void requestCalculationOnly() {
		try {
			ShapeName shapeName = selectShapeName();
	
			CalcType type = selectCalcType();

			double dimension = enterDimension();
		
			soapClient.queueCalculation(shapeName, type, dimension);
		
		} catch (IllegalArgumentException e)  { }
		
	}

	
	
	private ShapeName selectShapeName() {
		
		String line = "";
		
		for (;;) {

			System.out.print(selectShapeMenu);

			try {
				line=this.in.readLine();
			} catch (IOException e) {
				logger.debug(e.getMessage(),e);
			}

			if ("1".equals(line)) {
				return ShapeName.CIRCLE;
			} else if ("2".equals(line)) {
				return ShapeName.SQUARE;
			} else if ("3".equals(line)) {
				return ShapeName.EQUILATERALTRIANGLE;
			} else if ("4".equals(line)) {
				return ShapeName.SPHERE;
			} else if ("5".equals(line)) {
				return ShapeName.CUBE;
			} else if ("6".equals(line)) {
				return ShapeName.TETRAHEDRON;
			} else if ("Q".toLowerCase().equals(line.toLowerCase())) {
				System.exit(0);
			}
		}
	}
	
	private CalcType selectCalcType() {
		
		String line = "";
		
		for (;;) {

			System.out.print(selectTypeMenu);

			try {
				line=this.in.readLine();
			} catch (IOException e) {
				logger.debug(e.getMessage(),e);
			}

			if ("1".equals(line)) {
				return CalcType.CALC_AREA;
			} else if ("2".equals(line)) {
				return CalcType.CALC_VOLUME;
			} else if ("3".equals(line)) {
				return CalcType.CALC_FOO;
			} else if ("4".equals(line)) {
				return CalcType.CALC_FOOBAR;
			} else if ("5".equals(line)) {

			} else if ("6".equals(line)) {

			} else if ("Q".toLowerCase().equals(line.toLowerCase())) {
				System.exit(0);
			}
		}
	}

	private double enterDimension() {
		
		String line = "";
		
		double dimension = 0;
		
		for (;;) {

			System.out.print(enterDimMenu);

			try {
				line=this.in.readLine();
			} catch (IOException e) {
				logger.debug(e.getMessage(),e);
			}

			try {
				dimension = Double.parseDouble(line);
				return dimension;
			} catch (NumberFormatException e) { }

		}
	}	
	
	
	public static void main(String[] args) throws Exception {

        URL wsdlURL = ShapeCalculatorWebServiceImplService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		CmdLineShapeCalcApp app = new CmdLineShapeCalcApp(in,wsdlURL);
		
		System.out.println(userInputMessage);
		System.out.println();
		System.out.println(finalReportMessage);
		System.out.println();
		System.out.println(continueMessage);
		in.readLine();

		while (1==1) {
			app.doIt();
		}

	}

}
