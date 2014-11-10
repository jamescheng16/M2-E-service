//
//  ViewController.h
//  ConsumerWebService
//
//  Created by james on 10/11/14.
//  Copyright (c) 2014 Xiaojun. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController
@property (nonatomic, strong) IBOutlet UILabel *greetingId;
@property (nonatomic, strong) IBOutlet UILabel *greetingContent;

- (IBAction)fetchGreeting;

@end

