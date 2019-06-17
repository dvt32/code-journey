import React, { Component } from 'react'

import Api from '../services/Api'

import ReactExport from 'react-export-excel';

import DatePicker from 'react-datepicker';

import "react-datepicker/dist/react-datepicker.css";

const ExcelFile = ReactExport.ExcelFile;
const ExcelSheet = ReactExport.ExcelFile.ExcelSheet;
const ExcelColumn = ReactExport.ExcelFile.ExcelColumn;

class StatsPage extends Component {
  
  constructor (props) {
    super(props)
    this.state = {
      numberOfUsers: 0,
      moderatorUsernames: [],
      adminUsernames: [],
      topThreeTopicsWithMostReplies: [],
      topThreeTopicsWithMostViews: [],
      startDate: null,
      endDate: null
    }
    this.handleStartDateChange = this.handleStartDateChange.bind(this);
    this.handleEndDateChange = this.handleEndDateChange.bind(this);
  }

  /*
    This method is invoked immediately after the component has been mounted (inserted into the DOM)
  */
  componentDidMount() {
    this.sendGetRequestAndSetStateForNumberOfUsers();
    this.sendGetRequestAndSetStateForListOfModerators();
    this.sendGetRequestAndSetStateForListOfAdmins();
    this.sendGetRequestAndSetStateForTopThreeMostRepliedToTopicsOfAllTime();
    this.sendGetRequestAndSetStateForTopThreeMostViewedTopicsOfAllTime();
  }

  /*
    This method is invoked when the user has changed the start date value in the DatePicker component.
  */
  handleStartDateChange(newStartDate) {
    this.setState({
      startDate: newStartDate
    });

    // Update list of topics
    if (this.state.endDate !== null && newStartDate !== null &&
        newStartDate.getTime() < this.state.endDate.getTime()) 
    {
      let startDateString = (newStartDate.getMonth()+1) + "/" + newStartDate.getDate()+ "/" + newStartDate.getFullYear();
      let endDateString = (this.state.endDate.getMonth()+1) + "/" + this.state.endDate.getDate()+ "/" + this.state.endDate.getFullYear();
      this.sendGetRequestAndSetStateForTopThreeMostRepliedToTopicsInRange(startDateString, endDateString);
      this.sendGetRequestAndSetStateForTopThreeMostViewedTopicsInRange(startDateString, endDateString);
    }
    else if (this.state.endDate === null && newStartDate === null) {
      this.sendGetRequestAndSetStateForTopThreeMostRepliedToTopicsOfAllTime();
      this.sendGetRequestAndSetStateForTopThreeMostViewedTopicsOfAllTime();
    }
  }

  /*
    This method is invoked when the user has changed the end date value in the DatePicker component.
  */
  handleEndDateChange(newEndDate) {
    this.setState({
      endDate: newEndDate
    });

    // Update list of topics
    if (this.state.startDate !== null && newEndDate !== null &&
        this.state.startDate.getTime() < newEndDate.getTime()) 
    {
      let startDateString = (this.state.startDate.getMonth()+1) + "/" + this.state.startDate.getDate()+ "/" + this.state.startDate.getFullYear();
      let endDateString = (newEndDate.getMonth()+1) + "/" + newEndDate.getDate()+ "/" + newEndDate.getFullYear();
      this.sendGetRequestAndSetStateForTopThreeMostRepliedToTopicsInRange(startDateString, endDateString);
      this.sendGetRequestAndSetStateForTopThreeMostViewedTopicsInRange(startDateString, endDateString);
    }
    else if (this.state.startDate === null && newEndDate === null) {
      this.sendGetRequestAndSetStateForTopThreeMostRepliedToTopicsOfAllTime();
      this.sendGetRequestAndSetStateForTopThreeMostViewedTopicsOfAllTime();
    }
  }

  sendGetRequestAndSetStateForNumberOfUsers() {
    Api.setInterseptor(this.props).getNumberOfUsers().then(
      (response) => {
        this.setState({ numberOfUsers: response.data });
      }
    ).catch(error => console.log(error));
  }

  sendGetRequestAndSetStateForListOfModerators() {
    Api.setInterseptor(this.props).getListOfModerators().then(
      (response) => {
        var usernames = [];
        for (let i = 0; i < response.data.length; ++i) {
          usernames.push(response.data[i].username);
        }
        this.setState({ moderatorUsernames: usernames });
      }
    ).catch(error => console.log(error));
  }

  sendGetRequestAndSetStateForListOfAdmins() {
    Api.setInterseptor(this.props).getListOfAdmins().then(
      (response) => {
        var usernames = [];
        for (let i = 0; i < response.data.length; ++i) {
          usernames.push(response.data[i].username);
        }
        this.setState({ adminUsernames: usernames });
      }
    ).catch(error => console.log(error));
  }

  sendGetRequestAndSetStateForTopThreeMostRepliedToTopicsOfAllTime() {
    Api.setInterseptor(this.props).getTopThreeMostRepliedToTopics().then(
      (response) => {
        var topics = [];
        for (let i = 0; i < response.data.length; ++i) {
          topics.push(response.data[i]);
        }
        this.setState({ topThreeTopicsWithMostReplies: topics });
      }
    ).catch(error => console.log(error));
  }

  sendGetRequestAndSetStateForTopThreeMostViewedTopicsOfAllTime() {
    Api.setInterseptor(this.props).getTopThreeMostViewedTopics().then(
      (response) => {
        var topics = [];
        for (let i = 0; i < response.data.length; ++i) {
          topics.push(response.data[i]);
        }
        this.setState({ topThreeTopicsWithMostViews: topics });
      }
    ).catch(error => console.log(error));
  }

  sendGetRequestAndSetStateForTopThreeMostRepliedToTopicsInRange(startDateString, endDateString) {
    Api.setInterseptor(this.props).getTopThreeMostRepliedToTopicsInRange(startDateString, endDateString).then(
      (response) => {
        var topics = [];
        for (let i = 0; i < response.data.length; ++i) {
          topics.push(response.data[i]);
        }
        this.setState({ topThreeTopicsWithMostReplies: topics });
      }
    ).catch(error => console.log(error));
  }

  sendGetRequestAndSetStateForTopThreeMostViewedTopicsInRange(startDateString, endDateString) {
    Api.setInterseptor(this.props).getTopThreeMostViewedTopicsInRange(startDateString, endDateString).then(
      (response) => {
        var topics = [];
        for (let i = 0; i < response.data.length; ++i) {
          topics.push(response.data[i]);
        }
        this.setState({ topThreeTopicsWithMostViews: topics });
      }
    ).catch(error => console.log(error));
  }

  getExcelFileData() {
    const { 
      numberOfUsers, 
      moderatorUsernames, 
      adminUsernames, 
      topThreeTopicsWithMostReplies, 
      topThreeTopicsWithMostViews
    } = this.state;

    let numberOfUsersExcelSheetData = [ 
      { numberOfUsers: numberOfUsers }
    ];

    let listOfModeratorsExcelSheetData = [];
    for (let i = 0; i < moderatorUsernames.length; ++i) {
      listOfModeratorsExcelSheetData.push( { moderatorUsername: moderatorUsernames[i] } );
    }

    let listOfAdminsExcelSheetData = [];
    for (let i = 0; i < adminUsernames.length; ++i) {
      listOfAdminsExcelSheetData.push( { adminUsername: adminUsernames[i] } );
    }

    let topThreeTopicsWithMostRepliesExcelSheetData = [];
    for (let i = 0; i < topThreeTopicsWithMostReplies.length; ++i) {
      topThreeTopicsWithMostRepliesExcelSheetData.push( 
        { 
          id: topThreeTopicsWithMostReplies[i].id, 
          title: topThreeTopicsWithMostReplies[i].title,
          replyCount: topThreeTopicsWithMostReplies[i].replyCount
        } 
      );
    }

    let topThreeTopicsWithMostViewsExcelSheetData = [];
    for (let i = 0; i < topThreeTopicsWithMostViews.length; ++i) {
      topThreeTopicsWithMostViewsExcelSheetData.push( 
        { 
          id: topThreeTopicsWithMostViews[i].id, 
          title: topThreeTopicsWithMostViews[i].title,
          viewsCount: topThreeTopicsWithMostViews[i].viewsCount
        } 
      );
    }

    let excelFileData = {
      numberOfUsersExcelSheetData: numberOfUsersExcelSheetData,
      listOfModeratorsExcelSheetData: listOfModeratorsExcelSheetData,
      listOfAdminsExcelSheetData: listOfAdminsExcelSheetData,
      topThreeTopicsWithMostRepliesExcelSheetData: topThreeTopicsWithMostRepliesExcelSheetData,
      topThreeTopicsWithMostViewsExcelSheetData: topThreeTopicsWithMostViewsExcelSheetData
    }

    return excelFileData;
  }

  getTopicRangeString() {
    const { startDate, endDate } = this.state;

    let topicRangeString = '';
    if (startDate === null && endDate === null) {
      topicRangeString = 'all-time';
    }
    else if (startDate !== null && endDate === null) {
      topicRangeString = 
        (startDate.getMonth()+1) + "/" + startDate.getDate()+ "/" + startDate.getFullYear() + " - ";
    }
    else if (startDate === null && endDate !== null) {
      topicRangeString = 
        " - " + (endDate.getMonth()+1) + "/" + endDate.getDate()+ "/" + endDate.getFullYear();
    }
    else {
      if (startDate.getTime() < endDate.getTime()) {
        topicRangeString =
          (startDate.getMonth()+1) + "/" + startDate.getDate()+ "/" + startDate.getFullYear() + " - " +
          (endDate.getMonth()+1) + "/" + endDate.getDate()+ "/" + endDate.getFullYear();
      }
      else {
        topicRangeString = 'all-time';
      }
    }

    return topicRangeString;
  }

  render () {
    const { 
      numberOfUsers, 
      moderatorUsernames, 
      adminUsernames, 
      topThreeTopicsWithMostReplies, 
      topThreeTopicsWithMostViews, 
      startDate, 
      endDate
    } = this.state;

    const excelFileData = this.getExcelFileData();
    const topicRangeString = this.getTopicRangeString();

    return (
      <div>
        <h1>Forum Stats</h1>
        <p>Number of users: {numberOfUsers}</p>
        <p>List of Moderators: </p>
        <ul>
          {
            moderatorUsernames.map(
              (value, index) => {
                return <li key={index}>{value}</li>
              }
            )
          }
        </ul>
        <p>List of Admins: </p>
        <ul>
          {
            adminUsernames.map(
              (value, index) => {
                return <li key={index}>{value}</li>
              }
            )
          }
        </ul>
        <p>Top 3 Topics With Most Replies ({topicRangeString}):</p>
        <ol>
          {
            topThreeTopicsWithMostReplies.map(
              (value, index) => {
                return (
                  <li key={index}>
                    <a href={"/topics/" + value.id}>{value.title}</a> ({value.replyCount} replies)
                  </li>
                )
              }
            )
          }
        </ol>
        <p>Top 3 Most Viewed Topics ({topicRangeString}):</p>
        <ol>
          {
            topThreeTopicsWithMostViews.map(
              (value, index) => {
                return (
                  <li key={index}>
                    <a href={"/topics/" + value.id}>{value.title}</a> ({value.viewsCount} views)
                  </li>
                )
              }
            )
          }
        </ol>
        <p></p>

        Filter Top Topics By Date Range (Date Created On): <br /><br />
        - Start date:&nbsp;
        <DatePicker
          selected={startDate}
          selectsStart
          startDate={startDate}
          endDate={endDate}
          onChange={this.handleStartDateChange}
          maxDate={new Date()}
        />

        <br />
        - End date:&nbsp;
        <DatePicker
            selected={endDate}
            selectsEnd
            startDate={startDate}
            endDate={endDate}
            onChange={this.handleEndDateChange}
            minDate={startDate}
            maxDate={new Date()}
        />

        <br /><br />

        <ExcelFile 
          element={<button className="btn btn-primary">Export (.XLSX)</button>}
          filename="forum-stats"
        >
          <ExcelSheet data={excelFileData.numberOfUsersExcelSheetData} name="UserCount">
              <ExcelColumn label="Number of users" value="numberOfUsers" />
          </ExcelSheet>
          <ExcelSheet data={excelFileData.listOfModeratorsExcelSheetData} name="ModeratorList">
              <ExcelColumn label="Username" value="moderatorUsername" />
          </ExcelSheet>
          <ExcelSheet data={excelFileData.listOfAdminsExcelSheetData} name="AdminList">
              <ExcelColumn label="Username" value="adminUsername" />
          </ExcelSheet>
          <ExcelSheet data={excelFileData.topThreeTopicsWithMostRepliesExcelSheetData} name="Top3TopicsWithMostReplies">
              <ExcelColumn label="ID" value="id" />
              <ExcelColumn label="Title" value="title" />
              <ExcelColumn label="Reply Count" value="replyCount" />
          </ExcelSheet>
          <ExcelSheet data={excelFileData.topThreeTopicsWithMostViewsExcelSheetData} name="Top3TopicsWithMostViews">
              <ExcelColumn label="ID" value="id" />
              <ExcelColumn label="Title" value="title" />
              <ExcelColumn label="View Count" value="viewsCount" />
          </ExcelSheet>
        </ExcelFile>
      </div>
    )
  }

}

export default StatsPage